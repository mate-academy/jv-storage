package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_STORAGE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[LENGTH_STORAGE];
        values = (V[]) new Object[LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if (values[i] != null && (key == keys[i]) || (keys[i] != null
                    && keys[i].equals(key))
                    || (keys[i] == null && values[i] == null)) {
                size++;
                values[i] = value;
                keys[i] = key;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (values[i] != null && (key == keys[i]) || (keys[i] != null
                    && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                result++;
            }
        }
        return result;
    }
}
