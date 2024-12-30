package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    V [] array = (V[]) new Object[MAX_ITEMS_NUMBER];

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        Integer key1 = (Integer) key;
        if(key1 < 1 || key1 > 10){
            throw new IllegalArgumentException("Number is out of range! - Try something between 1 and 10");
        }
        array[key1] = value;
    }

    @Override
    public V get(K key) {
        Integer key1 = (Integer) key;
        if(key1 < 1 || key1 > 10){
            throw new IllegalArgumentException("Number is out of range! - Try something between 1 and 10");
        }
        return array[key1];
    }

    @Override
    public int size() {
        if(array.length == 0){
            return -1;
        }
        return array.length;
    }
}
