package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[ARRAY_SIZE];
        values = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            int lastElement;
            lastElement = size();
            keys[lastElement] = key;
            values[lastElement] = value;
        } else {
            values[index] = value;
        }   
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return (index == -1) ? null : (V)values[index];
    }

    @Override
    public int size() {
        int arraySize = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (values[i] != null) {
                arraySize++;
            }
        }
        return arraySize;
    }

    private int getKeyIndex(Object key) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if ((this.keys[i] == null && key == null) || (this.keys[i] != null 
                    && this.keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
