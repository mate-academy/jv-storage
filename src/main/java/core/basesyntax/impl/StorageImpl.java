package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] arrayKey = (K[]) new Object[MAX_ITEMS_NUMBER];
    private V[] arrayValue = (V[]) new Object[MAX_ITEMS_NUMBER];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        if (getIndex(key) >= 0) {
            arrayValue[getIndex(key)] = value;
            return;
        }
        arrayKey[count] = key;
        arrayValue[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        if (getIndex(key) >= 0) {
            return arrayValue[getIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndex(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
                return i;
            }
        }
        return -1;
    }
}
