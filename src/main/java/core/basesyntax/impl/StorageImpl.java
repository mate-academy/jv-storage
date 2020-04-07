package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int count = 0;

    public StorageImpl() {
        this.keys = new Object[ARRAY_MAX_LENGTH];
        this.values = new Object[ARRAY_MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (whereContain(key) == -1) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            values[whereContain(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return whereContain(key) == -1 ? null : (V) values[whereContain(key)];
    }

    private int whereContain(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
