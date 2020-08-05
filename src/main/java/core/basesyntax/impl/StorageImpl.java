package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int counter = 0;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (keys[i] == null ? keys[i] == key : keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
    }

    @Override
    public V get(K myKey) {
        for (int i = 0; i < counter; i++) {
            if (keys[i] == null ? keys[i] == myKey : keys[i].equals(myKey)) {
                return values[i];
            }
        }
        return null;
    }
}
