package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARR_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_ARR_SIZE];
        values = new Object[MAX_ARR_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int sameKeyIndex = -1;
        for (int i = 0; i < MAX_ARR_SIZE; i++) {
            if (values[i] != null && (key != null && key.equals((K) keys[i])
                    || key == null && keys[i] == null)) {
                sameKeyIndex = i;
            }
        }
        if (sameKeyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[sameKeyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ARR_SIZE; i++) {
            if (key != null && key.equals((K) keys[i]) || key == null && keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

}
