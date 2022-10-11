package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NULL_POINT = -1;
    private int count;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        count = 0;
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == NULL_POINT) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            values[getIndex(key)] = value;
        }

    }

    @Override
    public V get(K key) {
        return getIndex(key) > NULL_POINT ? values[getIndex(key)] : null;
    }

    @Override
    public int size() {
        return count;
    }

    private boolean checkValue(K key, int i) {
        return ((key == keys[i]) || (key != null && key.equals(keys[i])));
    }

    private int getIndex(K key) {
        for (int i = 0; i < count; i++) {
            if (checkValue(key, i)) {
                return i;
            }
        }
        return NULL_POINT;
    }
}
