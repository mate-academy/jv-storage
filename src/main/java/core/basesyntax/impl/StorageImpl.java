package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_CAPACITY = 10;
    private final StorageElement<K, V>[] storageElements = new StorageElement[STORAGE_MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        StorageElement<K, V> storageElement = new StorageElement<>(key, value);
        for (int i = 0; i < STORAGE_MAX_CAPACITY; i++) {
            if (storageElements[i] == null || storageElements[i].isEmpty()) {
                storageElements[i] = storageElement;
                return;
            } else if (storageElements[i].hasKey(storageElement.getKey())) {
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
                return (V) storageElement.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < STORAGE_MAX_CAPACITY; i++) {
            if (storageElements[i] == null) {
                return i;
            }
        }
        return STORAGE_MAX_CAPACITY;
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

        public V getValue() {
            return this.value;
        }
    }
}
