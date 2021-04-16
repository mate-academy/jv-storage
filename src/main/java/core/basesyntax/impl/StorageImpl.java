package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE_OF_ARRAY];
        this.values = (V[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
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
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
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
