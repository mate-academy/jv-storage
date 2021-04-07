package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int sizeCounter;


    public StorageImpl() {
        keys = new Object[ARRAY_SIZE];
        values = new Object[ARRAY_SIZE];
        sizeCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeCounter; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[sizeCounter] = key;
        values[sizeCounter] = value;
        sizeCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeCounter; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
               return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCounter;
    }
}
