package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS];
        values = (V[]) new Object[MAX_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                this.values[i] = value;
                return;
            }
        }
        this.keys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }
}
