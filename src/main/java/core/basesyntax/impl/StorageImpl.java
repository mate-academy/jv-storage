package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] key;
    private Object[] value;
    private int sizeTracker = 0;

    public StorageImpl() {
        this.key = new Object[10];
        this.value = new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) != -1) {
            this.value[getIndex(key)] = value;
        } else {
            this.key[sizeTracker] = key;
            this.value[sizeTracker] = value;
            sizeTracker++;
        }
    }

    @Override
    public V get(K key) {
        return getIndex(key) != -1 ? ((V) value[getIndex(key)]) : null;
    }

    @Override
    public int size() {
        return sizeTracker;
    }

    private int getIndex(K key) {
        for (int i = 0; i < sizeTracker; i++) {
            if (key == null && this.key[i] == null) {
                return i;
            } else if (key == null || this.key[i] == null) {
                continue;
            }
            if (key.equals(this.key[i])) {
                return i;
            }
        }
        return -1;
    }
}
