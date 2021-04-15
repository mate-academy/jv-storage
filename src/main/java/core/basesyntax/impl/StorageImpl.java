package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_LIMIT = 10;
    private V[] values;
    private K[] keys;
    private int index;

    public StorageImpl() {
        this.values = (V[]) new Object[SIZE_LIMIT];
        this.keys = (K[]) new Object[SIZE_LIMIT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
