package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_CAPACITY = 10;
    private int size = 0;
    private final StorageElement<K, V>[] storageElements = new StorageElement[STORAGE_MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        StorageElement<K, V> storageElement = new StorageElement<>(key, value);
        for (int i = 0; i < STORAGE_MAX_CAPACITY; i++) {
            if (storageElements[i] == null) {
                size++;
                storageElements[i] = storageElement;
                return;
            } else if (storageElements[i].isEmpty()
                    || storageElements[i].hasKey(storageElement.getKey())) {
                storageElements[i] = storageElement;
                return;
            }
        }
        throw new RuntimeException("StorageImpl has no more space.");
    }

    @Override
    public V get(K key) {
        for (StorageElement<K, V> storageElement : storageElements) {
            if (storageElement != null && !storageElement.isEmpty() && storageElement.hasKey(key)) {
                return (V) storageElement.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
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

        public K getKey() {
            return key;
        }

        public boolean hasKey(K key) {
            if (key == this.key) {
                return true;
            }
            if (key == null || this.key == null) {
                return false;
            }
            return this.key.equals(key);
        }
    }
}
