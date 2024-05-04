package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keys = (K[])new Object[MAX_ELEMENTS_NUMBER];
    private V[] values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    private int sizeOfStorage;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        if (sizeOfStorage < MAX_ELEMENTS_NUMBER) {
            keys[sizeOfStorage] = key;
            values[sizeOfStorage] = value;
            sizeOfStorage++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}
