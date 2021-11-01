package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    private Object[] storageKeys = new Object[STORAGE_SIZE];
    private Object[] values = new Object[STORAGE_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storageKeys[i] == key || key != null && key.equals(storageKeys[i])) {
                values[i] = value;
                return;
            }
        }
        this.storageKeys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (key == storageKeys[j] || key != null && key.equals(storageKeys[j])) {
                return (V) values[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
