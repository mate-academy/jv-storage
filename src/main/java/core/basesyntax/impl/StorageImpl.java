package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_LENGTH = 10;
    private static final int NOT_FOUND_ELEM_IDX = -1;

    private final K[] keys;
    private final V[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.values = (V[]) new Object[MAX_ELEMENTS_LENGTH];
        this.keys = (K[]) new Object[MAX_ELEMENTS_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int existingKeyIndex = this.getKeyIndex(key);

        if (existingKeyIndex != NOT_FOUND_ELEM_IDX) {
            if (this.values[existingKeyIndex] == null) {
                this.size += 1;
            }

            this.values[existingKeyIndex] = value;
        } else {
            int freeIndex = this.size();

            this.keys[freeIndex] = key;
            this.values[freeIndex] = value;

            this.size += 1;
        }
    }

    @Override
    public V get(K key) {
        int index = this.getKeyIndex(key);

        if (index == NOT_FOUND_ELEM_IDX) {
            return null;
        }

        return this.values[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < this.keys.length; i += 1) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }

        return NOT_FOUND_ELEM_IDX;
    }
}
