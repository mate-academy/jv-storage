package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE_SIZE = 10;
    private Object[] keys = new Object[MAX_VALUE_SIZE];
    private Object[] values = new Object[MAX_VALUE_SIZE];
    private int count;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if ((key == null && key == keys[i])
                    || key != null && (key == keys[i] || key.equals(keys[i]))) {
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
            if ((key == null && key == keys[i])
                    || key != null && (key == keys[i] || key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
