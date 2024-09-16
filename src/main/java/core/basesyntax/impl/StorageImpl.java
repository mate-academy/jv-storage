package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE_IN_STORAGE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_VALUE_IN_STORAGE];
        this.values = (V[]) new Object[MAX_VALUE_IN_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
        for (int i = 0; i < size; i++) { // змінна сайз - спільний індекс до двох масивів
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
