package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int index = 0;
    private K[] keys;
    private V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int numberOfKey = findKey(key);
        if (numberOfKey < 0) {
            if (index >= CAPACITY) {
                throw new IllegalStateException("Storage capacity exceeded");
            }
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            values[numberOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int numberOfKey = findKey(key);
        return (numberOfKey >= 0) ? values[numberOfKey] : null;
    }

    @Override
    public int size() {
        return index;
    }

    private int findKey(K key) {
        for (int i = 0; i < index; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}


