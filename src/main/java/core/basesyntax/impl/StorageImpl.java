package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private Object [] keys;
    private Object [] values;
    private int count;
    private int index;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.count = 0;
        this.index = 0;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < count; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int foundIndex = findKeyIndex(key);
        if (foundIndex != -1) {
            values[foundIndex] = value;
            return;
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        int foundIndex = findKeyIndex(key);
        return (foundIndex != -1) ? (V) values[foundIndex] : null;
    }

    @Override
    public int size() {
        return count;
    }
}
