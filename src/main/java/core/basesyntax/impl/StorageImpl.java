package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_STORAGE_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        if (checkPairIndexByKey(key) >= 0) {
            storage[checkPairIndexByKey(key)] = new Pair<>(key, value);
            return;
        }
        storage[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        if (checkPairIndexByKey(key) >= 0) {
            return storage[checkPairIndexByKey(key)].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int checkPairIndexByKey(K key) {
        int i = 0;
        for (Pair<K, V> pair : storage) {
            if (pair != null && key == pair.getKey() || pair != null
                    && key != null && key.equals(pair.getKey())) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
