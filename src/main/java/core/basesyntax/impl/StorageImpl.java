package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_VALUE];
        this.valueArray = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            valueArray[index] = value;
        } else if (size < MAX_VALUE) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index != -1 ? valueArray[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == null ? key == null : keyArray[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}

