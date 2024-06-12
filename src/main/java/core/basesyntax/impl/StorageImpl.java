package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int currentIndex = findIndex(key);
        if (currentIndex != -1) {
            values[currentIndex] = value;
            return;
        }

        if (size == MAX_ARRAY_LENGTH) {
            throw new RuntimeException("Can't put new element into a storage. Storage is full");
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && key == keys[i]) {
                return i;
            }
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
