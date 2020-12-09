package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_LENGTH_ARRAY = 10;
    private static int itemCounter;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_LENGTH_ARRAY];
        values = (V[]) new Object[INITIAL_LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            keys[itemCounter] = key;
            values[itemCounter] = value;
            itemCounter++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < itemCounter; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
