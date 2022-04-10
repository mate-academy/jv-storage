package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                if (values[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    size++;
                    break;
                } else if (key == null) {
                    values[i] = value;
                    break;
                }
            } else if (keys[i] == key || keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V var = null;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
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
