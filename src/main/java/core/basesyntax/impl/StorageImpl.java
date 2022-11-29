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
            keys[size] = key;
            values[size] = value;
            size++;
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
        for (int i = 0; i < size; i++) {
            if (this.keys[i] == key || (this.keys[i] != null 
                    && this.keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
