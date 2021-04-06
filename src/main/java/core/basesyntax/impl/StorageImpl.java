package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NO_SUCH_INDEX = -1;
    private final Object[] values;
    private final Object[] keys;
    private int elementsCount;

    public StorageImpl() {
        values = new Object[ARRAY_SIZE];
        keys = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == NO_SUCH_INDEX) {
            keys[elementsCount] = key;
            values[elementsCount] = value;
            elementsCount++;
        } else {
            keys[index] = key;
            values[index] = value;
        }
    }

    public int getIndex(K key) {
        for (int i = 0; i < elementsCount; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return NO_SUCH_INDEX;
    }

    @Override
    public V get(K key) {
        return getIndex(key) == NO_SUCH_INDEX ? null : (V) values[getIndex(key)];
    }

    @Override
    public int size() {
        return elementsCount;
    }
}
