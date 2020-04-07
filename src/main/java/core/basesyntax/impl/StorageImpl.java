package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int LENGTH = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int emptyCell;

    public StorageImpl() {
        keyStorage = (K[]) new Object[LENGTH];
        valueStorage = (V[]) new Object[LENGTH];
        emptyCell = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < emptyCell; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                valueStorage[i] = value;
            }
        }
        keyStorage[emptyCell] = key;
        valueStorage[emptyCell] = value;
        emptyCell++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < emptyCell; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                return valueStorage[i];
            }
        }
        return null;
    }
}
