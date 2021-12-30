package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.size; i++) {
            if (check(i, key)) {
                values[i] = value;
                return;
            }
        }
        values[this.size] = value;
        keys[this.size] = key;
        this.size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (check(i, key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean check(int i, K key) {
        return key == keys[i] || (key != null && key.equals(keys[i]));
    }
}
