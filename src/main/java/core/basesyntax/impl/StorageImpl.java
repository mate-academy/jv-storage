package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("ALL")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        this.keys = new Object[MAX_STORAGE_SIZE];
        this.values = new Object[MAX_STORAGE_SIZE];
    }

    private int getFirstNullKey() {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (keys[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int getFirstEmptyKey() {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (keys[i] == null && values[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            int nullIndex = getFirstNullKey();
            values[nullIndex] = value;
        } else {
            for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
            int emptyKeyIndex = getFirstEmptyKey();
            keys[emptyKeyIndex] = key;
            values[emptyKeyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return (V) values[getFirstNullKey()];
        } else {
            for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
                if (key.equals(keys[i])) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (getFirstEmptyKey() != -1) {
            return getFirstEmptyKey();
        }
        return MAX_STORAGE_SIZE;
    }
}
