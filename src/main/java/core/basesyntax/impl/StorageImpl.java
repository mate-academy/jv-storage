package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int QUANTITY = 10;
    private int quantum = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[QUANTITY];
        values = (V[]) new Object[QUANTITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < quantum; i++) {
            if (key == null ? key == keys[i] : key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[quantum] = key;
        values[quantum] = value;
        quantum++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < quantum; i++) {
            if (key == null ? key == keys[i] : key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
