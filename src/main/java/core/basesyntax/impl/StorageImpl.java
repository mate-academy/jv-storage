package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUES = 10;
    private Object[] keys = new Object[MAX_VALUES];
    private Object[] values = new Object[MAX_VALUES];
    private int count;

    public StorageImpl() {
        keys = new Object[MAX_VALUES];
        values = new Object[MAX_VALUES];
    }

    private int valueResolve(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            values[valueResolve(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int k = valueResolve(key);
        return k == -1 ? null : (V) values[k];
    }

    @Override
    public int size() {
        return count;
    }
}
