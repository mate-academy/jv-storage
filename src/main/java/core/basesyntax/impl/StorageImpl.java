package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_SIZE];
        values = (V[]) new Object[MAXIMUM_SIZE];
        count = 0;
    }

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
        if ((newKey == null && newKey == keyFromArray)
                || (newKey != null && newKey.equals(keyFromArray))) {
            return true;
        }
        return false;
    }
}
