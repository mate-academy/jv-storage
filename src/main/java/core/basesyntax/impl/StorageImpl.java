package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[CAPACITY];
        valueArray = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            valueArray[index] = value;
            return;
        }
        if (size < CAPACITY) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new RuntimeException("Can not add key: " + key + " with value: " + value
                    + " because storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
