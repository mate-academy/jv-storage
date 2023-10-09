package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_LENGTH];
        this.values = (V[]) new Object[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyInStorage(key, i)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeyInStorage(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyInStorage(K key, int index) {
        return key == keys[index] || keys[index] != null && keys[index].equals(key);
    }
}
