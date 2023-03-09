package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_INDEX = 0;
    private static final int MAX_SIZE = 10;
    private final K[] arrayKey;
    private final V[] arrayValue;
    private int size;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_SIZE];
        arrayValue = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            arrayKey[INITIAL_INDEX] = key;
            arrayValue[INITIAL_INDEX] = value;
            size++;
        } else {
            int index = findIndex(key);
            if (index != -1) {
                arrayValue[index] = value;
            } else {
                arrayKey[size] = key;
                arrayValue[size] = value;
                size++;
            }
        }
    }

    private int findIndex(K element) {
        for (int i = 0; i < size; i++) {
            if ((arrayKey[i] == null && element == null)
                    || (arrayKey[i] != null && arrayKey[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return arrayValue[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
