package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (isEqual(keys[i], key)) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEqual(K first, K second) {
        return first == second || first != null && first.equals(second);
    }
}
