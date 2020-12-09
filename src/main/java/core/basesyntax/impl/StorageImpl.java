package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys = (K[]) new Object[ARRAY_LENGTH];
    private V[] values = (V[]) new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && values[i] == null)) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (key != null && key.equals(keys[i])) {
                values[i] = value;
                break;
            } else if (key == null && keys[i] == null && value != null) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key != null && key.equals(keys[i])) || key == keys[i]) {
                return values[i];
            }
            if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }
}
