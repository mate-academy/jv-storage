package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private K [] keys;
    private V [] values;
    private int size;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (consistIndex(i, key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (consistIndex(i, key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean consistIndex(int i, K key) {
        return key == keys[i] || key != null && key.equals(keys[i]);
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndex(int index) {
        if (index >= 0 && index <= MAX_ELEMENTS) {
            return index;
        }
        return -1;
    }
}
