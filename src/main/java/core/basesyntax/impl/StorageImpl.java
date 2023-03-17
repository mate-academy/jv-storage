package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private int sizeInt = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    private int findValueWithKey(K key) {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (values[i] != null && key == keys[i]
                    || key != null && keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findValueWithKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                sizeInt++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findValueWithKey(key);
        if (index == -1) {
            return null;
        } else {
            return values[index];
        }
    }

    @Override
    public int size() {
        return sizeInt;
    }

}


