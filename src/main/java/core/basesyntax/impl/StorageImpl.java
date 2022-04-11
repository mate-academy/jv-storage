package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int size;
    private final K[] keys = (K[]) new Object[STORAGE_SIZE];
    private final V[] values = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size(); i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
            if (key == null && value != null
                    && keys[i] == null && values[i] != null
                    && !values[i].equals(value)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            if (key == null && value != null && keys[i] == null && values[i] == null) {
                values[i] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size(); i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
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
