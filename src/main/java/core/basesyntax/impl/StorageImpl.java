package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ELEMENTS = 10;
    public static final int WRONG_INDEX = -1;
    private final Object[] keys;
    private final Object[] values;
    private int storageSize = 0;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENTS];
        values = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (getKeyIndex(key) == WRONG_INDEX) {
            keys[storageSize] = key;
            values[storageSize] = value;
            storageSize++;
        } else {
            values[getKeyIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index != WRONG_INDEX ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return WRONG_INDEX;
    }
}
