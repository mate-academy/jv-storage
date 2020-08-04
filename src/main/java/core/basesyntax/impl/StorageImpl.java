package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (key == keys[i]) {
                values[i] = value;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (key == keys[i]) {
                return values[i];
            }
        }
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
