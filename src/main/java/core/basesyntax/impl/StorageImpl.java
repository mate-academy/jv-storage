package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private static final int ZERO = 0;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.size = ZERO;
        this.keys = (K[]) new Object[MAX_NUMBER];
        this.values = (V[]) new Object[MAX_NUMBER];
    }

    private boolean compare(K keyLeft, K keyRight) {
        return keyLeft == keyRight || keyLeft != null && keyLeft.equals(keyRight);
    }

    @Override
    public void put(K key,V value) {
        for (int i = 0; i < size; i++) {
            if (compare(keys[i], key)) {
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
            if (compare(keys[i], key)) {
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
