package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final byte MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        size = 0;
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    public void insertKeyAndValue(int i, K key, V value) {
        this.keys[i] = key;
        this.values[i] = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                insertKeyAndValue(i, key, value);
                return;
            }
        }
        if (size < MAX_ITEMS_NUMBER) {
            insertKeyAndValue(size, key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(this.keys[i])) {
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
