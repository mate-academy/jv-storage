package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_LENGTH = 10;
    private V[] values;
    private K[] keys;
    private int size;

    public StorageImpl() {
        values = (V[]) new Object[INITIAL_LENGTH];
        keys = (K[])new Object[INITIAL_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(this.keys[i], key)) {
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
            if (compareKeys(this.keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareKeys(K first, K second) {
        return (first == second) || first != null && first.equals(second);
    }
}
