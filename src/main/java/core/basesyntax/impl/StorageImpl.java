package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 9;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    private void increaseStorageSize() {
        size++;
    }

    public int getSize() {
        return size;
    }

    private boolean isKeyAlreadyPresentInStorage(K newKey, K currentKey) {
        return (currentKey == newKey || (currentKey != null && currentKey.equals(newKey)));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < getSize(); i++) {
            if (isKeyAlreadyPresentInStorage(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        values[getSize()] = value;
        keys[getSize()] = key;
        increaseStorageSize();
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < getSize(); i++) {
            if (isKeyAlreadyPresentInStorage(key,keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return getSize();
    }
}
