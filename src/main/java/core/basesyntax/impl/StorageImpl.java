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
        for (int index = 0; index < LENGTH_ARRAY; index++) {
            if ((keys[index] != null && keys[index].equals(key)) && values[index] != null) {
                values[index] = value;
                break;
            } else if (keys[index] == null && values[index] == null) {
                keys[index] = key;
                values[index] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < LENGTH_ARRAY; index++) {
            if (keys[index] == key || (keys[index] != null && keys[index].equals(key))) {
                return values[index];
            }
        }
        return null;
    }
}
