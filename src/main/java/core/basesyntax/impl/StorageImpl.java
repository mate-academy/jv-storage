package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS_IN_STORAGE = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS_IN_STORAGE];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS_IN_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_NUMBER_OF_ELEMENTS_IN_STORAGE; i++) {
            if (keys[i] == null && values[i] == null
                    || key != null && key.equals(keys[i]) || key == keys[i]) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_NUMBER_OF_ELEMENTS_IN_STORAGE; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
