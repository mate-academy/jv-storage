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
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
            if (keyEquals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (getKeyIndex(key) >= 0) {
            return values[getKeyIndex(key)];
        }
        return null;
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

    private boolean keyEquals(Object first, Object second) {
        return (first == second) || (first != null && first.equals(second));
    }
}
