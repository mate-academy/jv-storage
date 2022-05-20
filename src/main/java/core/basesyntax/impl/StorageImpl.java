package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAYS_SIZE];
    private V[] values = (V[]) new Object[ARRAYS_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        keys[size] = key;
        values[size] = value;

        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && keys[i] == keys[size]) || (keys[i]
                    != null && keys[i].equals(keys[size]))) {
                keys[i] = key;
                values[i] = value;
                values[size] = null;
                keys[size] = null;
                size--;
                break;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        int find = 0;
        for (; find < size(); find++) {
            if (keys[find] == key || keys[find] != null && keys[find].equals(key)) {
                break;
            }
        }
        return values[find];
    }

    @Override
    public int size() {
        return size;
    }
}
