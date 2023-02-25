package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;
    private int indexKey = -1;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        checkIndexKey(key);
        if (size == 0 || indexKey == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[indexKey] = value;
            indexKey = -1;
        }
    }

    @Override
    public V get(K key) {
        checkIndexKey(key);
        if (indexKey != -1) {
            int index = indexKey;
            indexKey = -1;
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndexKey(K key) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (null == key && null == keys[i]) {
                    indexKey = i;
                } else if (null != key && null != keys[i] && key.equals(keys[i])) {
                    indexKey = i;
                }
            }
        }
    }
}
