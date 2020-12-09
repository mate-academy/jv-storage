package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int indexCurrent;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_LENGTH];
        this.values = (V[]) new Object[ARRAY_LENGTH];
        this.indexCurrent = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < indexCurrent; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }

        }
        keys[indexCurrent] = key;
        values[indexCurrent] = value;
        indexCurrent++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < indexCurrent; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}

