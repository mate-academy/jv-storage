package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_ARRAY_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_VALUE];
        values = (V[]) new Object[MAX_ARRAY_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
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
