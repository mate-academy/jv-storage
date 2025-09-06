package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final Pair<K, V>[] keyValuePairs;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyValuePairs = new Pair[MAX_STORAGE_CAPACITY];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            keyValuePairs[index].setValue(value);
        } else {
            if (currentSize < MAX_STORAGE_CAPACITY) {
                keyValuePairs[currentSize++] = new Pair<>(key, value);
            } else {
                throw new RuntimeException("Storage has reached maximum capacity");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index != -1 ? keyValuePairs[index].getValue() : null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < currentSize; i++) {
            K currentKey = keyValuePairs[i].getKey();
            if (currentKey == null && key == null) {
                return i;
            } else if (currentKey != null && currentKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }


    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
}
