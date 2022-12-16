package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        this.values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            this.values[getKeyIndex(key)] = value;
            return;
        }
        int lastIndex = size();
        this.keys[lastIndex] = key;
        this.values[lastIndex] = value;
    }

    @Override
    public V get(K key) {
        return getKeyIndex(key) >= 0
                ? values[getKeyIndex(key)]
                : null;
    }

    @Override
    public int size() {
        int count = 0;
        for (V datum : values) {
            if (datum != null) {
                count++;
            }
        }
        return count;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null)
                    || ((keys[i] != null && key != null) && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
