package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int keyPosition;

    public StorageImpl() {
        keyPosition = 0;
        keys = (K[]) new Object[STORAGE_LENGTH];
        values = (V[]) new Object[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyPosition; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[keyPosition] = key;
        values[keyPosition] = value;
        keyPosition++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyPosition; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
