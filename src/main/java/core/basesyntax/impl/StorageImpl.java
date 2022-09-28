package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int arraySize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_PAIRS_NUMBER];
        values = (V[]) new Object[MAX_PAIRS_NUMBER];
        arraySize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null && values[i] != null) {
                values[i] = value;
                return;
            }

            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[arraySize] = key;
        values[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i]) || key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
