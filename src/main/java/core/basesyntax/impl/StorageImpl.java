package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        this.values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        if (size < MAXIMUM_NUMBER_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
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
