package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_DEFAULT_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[ARRAY_DEFAULT_SIZE];
        values = new Object[ARRAY_DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex == -1 ? null : (V) values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null && values[i] != null
                    || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
