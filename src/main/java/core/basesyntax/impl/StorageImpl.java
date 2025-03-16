package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private KeyValuePair<K, V>[] storage = new KeyValuePair[MAX_STORAGE_SIZE];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        if (currentSize == MAX_STORAGE_SIZE) {
            throw new RuntimeException("No more place in storage");
        }
        for (int i = 0; i < currentSize; i++) {
            if (isEqual(key, storage[i].key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[currentSize] = new KeyValuePair<>(key, value);
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (isEqual(key, storage[i].key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean isEqual(Object firstObject, Object secondObject) {
        return firstObject == secondObject
                || firstObject != null && firstObject.equals(secondObject);
    }

    private static class KeyValuePair<K, V> {
        private K key;
        private V value;

        private KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
