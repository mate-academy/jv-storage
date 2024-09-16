package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MIN_SIZE_OF_ARRAY = 0;
    private static final int MAX_SIZE_OF_ARRAY = 10;
    private int size;
    private final K[] keyArr;
    private final V[] valueArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_SIZE_OF_ARRAY];
        valueArr = (V[]) new Object[MAX_SIZE_OF_ARRAY];
    }

    public int indexKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArr[i] == null ? keyArr[i] == key : keyArr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexKey(key);
        if (index >= MIN_SIZE_OF_ARRAY) {
            valueArr[index] = value;
        } else if (size < MAX_SIZE_OF_ARRAY) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexKey(key);
        if (index >= MIN_SIZE_OF_ARRAY) {
            return valueArr[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

