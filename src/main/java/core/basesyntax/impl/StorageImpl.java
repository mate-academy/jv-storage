package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keyStore;
    private V[] valueStore;
    private int size;

    public StorageImpl() {
        keyStore = (K[]) new Object[ARRAY_LENGTH];
        valueStore = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == keyStore[i]) || (key != null && key.equals(keyStore[i]))) {
                valueStore[i] = value;
                return;
            }
        }
        keyStore[size] = key;
        valueStore[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keyStore[i]) || (key != null && key.equals(keyStore[i]))) {
                return valueStore[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
