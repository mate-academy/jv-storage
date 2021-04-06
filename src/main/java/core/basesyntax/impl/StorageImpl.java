package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_LENGTH];
        this.values = (V[]) new Object[ARRAY_LENGTH];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size + 1; i++) {
            if (key == null) {
                if (keys[i] == null && values[i] != null) {
                    size--;
                }
                break;
            }
            if (key.equals(keys[i])) {
                size--;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return values[i];
                }
                continue;
            }
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return values[0];
    }

    @Override
    public int size() {
        return size;
    }
}
