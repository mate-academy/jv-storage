package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int maxSize = 10;

    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("uncheked")
    public StorageImpl() {
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < maxSize) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = keys[i];
            if (key == null) {
                if (currentKey == null) {
                    return i;
                }
            } else {
                if (key.equals(currentKey)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
