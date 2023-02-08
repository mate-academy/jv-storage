package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            return;
        }

        int index = contains(key);

        if (index == -1) {
            values[size] = value;
            keys[size] = key;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = contains(key);
        if (index != -1) {
            return values[index];
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int contains(K key) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                index = i;
            }
        }

        return index;
    }
}
