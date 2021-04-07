package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final K [] keys;
    private final V [] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE_OF_ARRAY];
        values = (V[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        while (i < size) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            i++;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int i = 0;
        while (i < size) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
            i++;
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }
}
