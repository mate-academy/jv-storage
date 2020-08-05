package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;

    private Object[] keys = new Object[SIZE];
    private Object[] values = new Object[SIZE];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keyCheck(key, i)) {
                keys[i] = key;
                values[i] = value;
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keyCheck(key, i)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public boolean keyCheck(K key, int i) {
        return key == null ? keys[i] == null : key.equals(keys[i]);
    }
}
