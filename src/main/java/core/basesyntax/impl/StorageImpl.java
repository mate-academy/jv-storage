package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int Capacity = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[Capacity];
        values = (V[]) new Object[Capacity];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if ((keys[i] == key) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        int currentSize = size();
        if (currentSize < Capacity) {
            keys[currentSize] = key;
            values[currentSize] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if ((keys[i] == key) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
