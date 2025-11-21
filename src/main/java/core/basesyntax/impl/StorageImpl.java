package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;
    private final int maxSize = 10;

    public StorageImpl() {
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean keyExists = false;
        for (int i = 0; i < size; i++) {
            if (checkKeys(key, keys[i])) {
                values[i] = value;
                keyExists = true;
                break;
            }
        }
        if (!keyExists) {
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    private boolean checkKeys(K a, K b) {
        return (a != null && b != null) && a.equals(b)
                || (a == null && b == null);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(key, keys[i])) {
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
