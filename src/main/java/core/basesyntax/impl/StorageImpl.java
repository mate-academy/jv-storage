package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int sizeTracker;

    public StorageImpl() {
        this.keys = new Object[ARRAY_SIZE];
        this.values = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != -1) {
            this.values[getIndex(key)] = value;
        } else {
            this.keys[sizeTracker] = key;
            this.values[sizeTracker] = value;
            sizeTracker++;
        }
    }

    @Override
    public V get(K key) {
        return getIndex(key) != -1 ? ((V) values[getIndex(key)]) : null;
    }

    @Override
    public int size() {
        return sizeTracker;
    }

    private int getIndex(K key) {
        for (int i = 0; i < sizeTracker; i++) {
            if (key == keys[i]) {
                return i;
            } else if (key == null) {
                continue;
            }
            if (key.equals(this.keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
