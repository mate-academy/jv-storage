package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys = (K[]) new Object[MAX_STORAGE_SIZE];
    private final V[] values = (V[]) new Object[MAX_STORAGE_SIZE];
    private int index;

    @Override
    public void put(K key, V value) {
        if (key != null) {
            if (key.equals(keys[index == 0 ? index : index - 1])) {
                values[index - 1] = value;
                keys[index - 1] = key;
                return;
            }
        }
        values[index] = value;
        keys[index] = key;
        index++;
        if (keys[0] == null & values[0] != null) {
            index = 1;
        }
    }

    @Override
    public V get(K key) {
        if (key != null) {
            for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        for (int i = MAX_STORAGE_SIZE; i > 0; i--) {
            if (keys[i - 1] == null & values[i - 1] != null) {
                return values[i - 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
