package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int NON_EXISTENT_KEY = -1;
    private static final int LOWER_BORDER = 0;
    private final K[] keyArr;
    private final V[] valueArr;
    private int size;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_ARRAY_SIZE];
        valueArr = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (indexKey(key) >= LOWER_BORDER) {
            valueArr[indexKey(key)] = value;
        } else if (size < MAX_ARRAY_SIZE) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (indexKey(key) >= LOWER_BORDER) {
            return valueArr[indexKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArr[i] || (keyArr[i] != null && keyArr[i].equals(key))) {
                return i;
            }
        }
        return NON_EXISTENT_KEY;
    }
}
