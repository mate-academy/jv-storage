package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int FULL_SIZE_ARRAY = 10;
    private Object[] keys = new Object[FULL_SIZE_ARRAY];
    private Object[] values = new Object[FULL_SIZE_ARRAY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        size++;
        keys[size] = key;
        values[size] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                if (size == 0) {
                    size = size + 1;
                }
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
