package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] != null) {
                continue;
            }
            if (key == null && key == keys[i]) {
                values[i] = value;
            }
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            if (keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (key == null && keys[i] == null || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
