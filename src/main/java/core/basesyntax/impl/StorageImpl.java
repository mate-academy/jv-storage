package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K,V> implements Storage<K,V> {
    private static final int STORAGE_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_LENGTH];
        values = (V[]) new Object[STORAGE_LENGTH];
        size = 0;
    }

    @Override
    public void put(K keyPut, V valuePut) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? keyPut == null : keys[i].equals(keyPut)) {
                values[i] = valuePut;
                return;
            }
        }
        keys[size] = keyPut;
        values[size] = valuePut;
        size++;
    }

    @Override
    public V get(K keyGet) {
        for (int i = 0; i < size; i++) {
            if (keyGet == keys[i] || (keyGet != null && keyGet.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }
}
