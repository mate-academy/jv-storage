package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private V[] values;
    private K[] keys;
    private int index;
    private int indexExistKey;

    public StorageImpl() {
        values = (V[]) new Object[DEFAULT_CAPACITY];
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        index = 0;
        indexExistKey = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            values[indexExistKey] = value;
            return;
        } else {
            values[index] = value;
            keys[index++] = key;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                indexExistKey = i;
                return values[i];
            }
        }
        return null;
    }
}
