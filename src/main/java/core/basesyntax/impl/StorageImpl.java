package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int sizeOfStorage;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE_OF_ARRAY];
        this.values = (V[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        if (sizeOfStorage >= SIZE_OF_ARRAY) {
            throw new RuntimeException("The storage is full!");
        }
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] == key) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[sizeOfStorage] = key;
        values[sizeOfStorage] = value;
        sizeOfStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] == key) || (key != null && key.equals(keys[i]))) {
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
