package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_ARRAY = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[LENGTH_ARRAY];
        values = (V[]) new Object[LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            if ((keys[i] != null && keys[i].equals(key)) && values[i] != null) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }
}
