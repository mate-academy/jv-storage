package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private KayValePair<K, V>[] storage = new KayValePair[MAX_STORAGE_SIZE];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        if (currentSize == MAX_STORAGE_SIZE) {
            throw new RuntimeException("No more place in storage");
        }
        for (int i = 0; i < currentSize; i++) {
            if (isEqual(key, storage[i].getKey())) {
                storage[i].setValue(value);
                return;
            }
        }
        storage[currentSize] = new KayValePair<>(key, value);
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (isEqual(key, storage[i].getKey())) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean isEqual(Object firstObject, Object secondObject) {
        if (firstObject == secondObject
                || firstObject != null && firstObject.equals(secondObject)) {
            return true;
        }
        return false;
    }

    private static class KayValePair<K, V> {
        private K key;
        private V value;

        private KayValePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setKey(K key) {
            this.key = key;
        }

        private void setValue(V value) {
            this.value = value;
        }
    }
}
