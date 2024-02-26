package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private final K[] keyArr;
    private final V[] valueArr;
    private int size;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_SIZE];
        valueArr = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != NOT_FOUND_INDEX) {
            valueArr[index] = value;
            size--;
        }
        if (size < MAX_SIZE) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index != NOT_FOUND_INDEX) {
            return valueArr[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArr[i] || key != null && key.equals(keyArr[i])) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
