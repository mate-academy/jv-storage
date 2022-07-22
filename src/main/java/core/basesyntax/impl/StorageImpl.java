package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int sizeCounter;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
        sizeCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            this.keys[sizeCounter] = key;
            this.values[sizeCounter] = value;
            sizeCounter++;
        } else {
            for (int i = 0; i < sizeCounter; i++) {
                if ((this.keys[i] == key) || (this.keys[i] != null) && (this.keys[i].equals(key))) {
                    this.values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeCounter; i++) {
            if ((this.keys[i] == key) || (this.keys[i] != null) && (this.keys[i].equals(key))) {
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
