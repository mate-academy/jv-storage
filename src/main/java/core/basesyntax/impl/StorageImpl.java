package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (size == keys.length) {
                throw new RuntimeException("Storage is completely full");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return getKeyIndex(key) >= 0 ? values[getKeyIndex(key)] : null;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, keys[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyEquals(K first, K second) {
        return (first == second) || (first != null && first.equals(second));
    }
}
