package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size;
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
            size++;
            int lastElement = size - 1;
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
        return size;
    }

    private int getKeyIndex(Object key) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (((this.keys[i] == key) || (this.keys[i] != null 
                    && this.keys[i].equals(key))) && values[i] != null) {
                return i;
            }
        }
        return -1;
    }
}
