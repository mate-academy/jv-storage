package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[10];
        valueStorage = (V[]) new Object[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyStorage[i] == null || key != null && key.equals(keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyStorage[i] == null || key != null && key.equals(keyStorage[i])) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
