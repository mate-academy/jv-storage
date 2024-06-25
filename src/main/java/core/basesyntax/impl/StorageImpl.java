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
        int index = getIndexByKey(key);
        if (index >= 0) {
            storage[index] = new Pair<>(key, value);
            return;
        }
        storage[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index >= 0 ? storage[index].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
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
