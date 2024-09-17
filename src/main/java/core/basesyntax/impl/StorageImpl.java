package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_SIZE = 0;
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        this.size = START_SIZE;
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = keyContains(key);
        if (index >= 0) {
            valueArray[index] = value;
        } else if (size < MAX_SIZE) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = keyContains(key);
        if (index >= 0) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int keyContains(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == null ? keyArray[i] == key : keyArray[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
