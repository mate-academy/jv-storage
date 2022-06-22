package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyWasAdded = 0;
        for (int i = 0; i < keys.length; i++) {
            if (key == null && value != null) {
                if (keys[i] == null && values[i] != null) {
                    values[i] = value;
                    keyWasAdded = 1;
                    break;
                } else if (keys[i] == null && values[i] == null) {
                    values[size] = value;
                    size++;
                    keyWasAdded = 1;
                    break;
                }
            } else if (key.equals(keys[i])) {
                values[i] = value;
                keyWasAdded = 1;
                break;
            }

        }
        if (keyWasAdded == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null && values[i] != null) {
                return values[i];
            }
            if (key != null && key.equals(keys[i])) {
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
