package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
