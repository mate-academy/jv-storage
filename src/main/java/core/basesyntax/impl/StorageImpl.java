package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V > implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }


    @Override
    public void put(K key, V value) {
        int index = 0;
        for (K currentKey : keys){
            if (currentKey != null && currentKey.equals(key)) {
                values[index] = value;
            }

            index++;

            }
         if (size() < MAX_SIZE){
            keys[size()] = key;
            values[size()] = value;
            size++;
        } else {

        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (K currentKey : keys){
            if (currentKey != null && currentKey.equals(key)) {
                return values[index];
            }else if (currentKey == null && size != 0){
                return values[index];
            }
            index++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
