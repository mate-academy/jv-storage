package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE  = 10;
    private int size;
    private K[] keys = (K[]) new Object[maxArraySize];
    private V[] values = (V[]) new Object[maxArraySize];

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (key == keys[i]) {
                keys[i] = key;
                values[i] = value;
                return;
            } else if ((key != null && keys[i] != null) && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                return;
            } else {
                keys[size] = key;
                values[size] = value;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (key != null && keys[i] != null && key.equals(keys[i]))) {
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
