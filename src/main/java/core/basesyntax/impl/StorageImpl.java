package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_VOLUME = 10;
    private static final int NO_INDEX = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_VOLUME];
        values = (V[]) new Object[STORAGE_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == NO_INDEX) {
            try {
                keys[size] = key;
                values[size] = value;
                size++;
            } catch (RuntimeException e) {
                throw new ArrayIndexOutOfBoundsException("This Storage is full");
            }
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == NO_INDEX ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return NO_INDEX;
    }
}
