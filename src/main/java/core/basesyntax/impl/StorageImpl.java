package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == null && values[i] == null) {
                values[i] = value;
                break;
            }
            if (keys[i] == null && values[i] != null && key == null) {
                values[i] = value;
                size--;
                break;
            }
            if (keys[i] != null) {
                if (keys[i] != null && values[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    size--;
                    break;
                }
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("ERROR");
        }
    }

    @Override
    public V get(K key) {

        if (size() > MAX_SIZE) {
            return null;
        }
        for (int j = 0; j < MAX_SIZE; j++) {
            if (keys[j] == null && values[j] == null) {
                return null;
            }
            if (keys[j] != null && keys[j].equals(key)) {
                return values[j];
            }
            if (key == null && keys[j] == null && values[j] != null) {
                return values[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
