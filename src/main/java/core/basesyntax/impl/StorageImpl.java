package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (keys[i] == null && (key == null || values[i] == null)
                    || key != null && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                size = i + 1;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (key == null && keys[i] == null
                    || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
