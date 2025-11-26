package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;

    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[CAPACITY];
        this.values = (V[]) new Object[CAPACITY];
        this.size = 0;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null ? key.equals(keys[i]) : keys[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }
}
