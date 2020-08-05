package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public final static int MAXIMUM_SIZE = 10;
    private Object[] keys = new Object[MAXIMUM_SIZE];
    private Object[] values = new Object[MAXIMUM_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (check(key, keys[i])) {
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
            if (check(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean check(Object newKey, Object keyFromArray) {
        if (newKey == null && newKey == keyFromArray) {
            return true;
        }
        if (newKey != null && newKey.equals(keyFromArray)) {
            return true;
        }
        return false;
    }
}
