package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_OF_ELEMENTS = 10;
    private  Object[] keys;
    private  Object[] values;
    private int size;

    public StorageImpl(){
        size = 0;
        keys =  new Object[MAX_OF_ELEMENTS];
        values = new Object[MAX_OF_ELEMENTS];

    }
    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if(index == -1 ) {
            keys[size] = key;
            values[size++] = value;

        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for(int i = 0 ; i < size ; i++) {
            if(keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}

