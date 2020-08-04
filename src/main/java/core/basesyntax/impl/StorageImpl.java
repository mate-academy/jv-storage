package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGESIZE = 10;
    private K[] keys;
    private V[] values;
    private int counter = 0;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGESIZE];
        values = (V[]) new Object[STORAGESIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean isKeyUnique = true;
        for (int i = 0; i < counter; i++) {
            if (keys[i] == null ? keys[i] == key : keys[i].equals(key)) {
                values[i] = value;
                isKeyUnique = false;
            }
        }
        if (isKeyUnique) {
            this.keys[counter] = key;
            this.values[counter] = value;
            counter++;
        }
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
