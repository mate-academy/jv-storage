package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_CAPACITY = 10;
    private int size;
    private final StorageElement<K, V>[] storageElements = new StorageElement[STORAGE_MAX_CAPACITY];

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < STORAGE_MAX_CAPACITY; i++) {
            if (storageElements[i] == null) {
                storageElements[i] = new StorageElement<>(key, value);
                size++;
                return;
            } else if (storageElements[i].isEqualToKey(key)) {
                storageElements[i].value = value;
                return;
            }
        }
        throw new IllegalStateException("StorageImpl has no more space. Max space is"
                + STORAGE_MAX_CAPACITY);
    }

    @Override
    public V get(K key) {
        for (StorageElement<K, V> storageElement : storageElements) {
            if (storageElement != null && !storageElement.isEmpty()
                    && storageElement.isEqualToKey(key)) {
                return storageElement.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class StorageElement<K, V> {
        private K key;
        private V value;

        public StorageElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean isEmpty() {
            return key == null && value == null;
        }

        public boolean isEqualToKey(K key) {
            return key == this.key || key != null && key.equals(this.key);
        }
    }
}
