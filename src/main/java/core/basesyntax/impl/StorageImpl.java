package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH_MAX = 10;
    private K[] keysStorage;
    private V[] valuesStorage;
    private int size;

    public StorageImpl() {
        this.keysStorage = (K[]) new Object[ARRAY_LENGTH_MAX];
        this.valuesStorage = (V[]) new Object[ARRAY_LENGTH_MAX];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keysStorage[i] || key != null && key.equals(keysStorage[i])) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[size] = key;
        valuesStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null
                    && key.equals(keysStorage[i])
                    || key == keysStorage[i]) {
                return (V) valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
