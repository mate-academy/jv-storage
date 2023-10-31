package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int FIRST_ELEMENT = 0;
    private static final int STORAGE_LENGTH = 10;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[STORAGE_LENGTH];
        for (int i = 0; i < STORAGE_LENGTH; i++) {
            storage[i] = new Pair<>();
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalKey(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[size].key = key;
        storage[size].value = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (equalKey(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean equalKey(K firstKey, K secondKey) {
        return firstKey == secondKey
                || (firstKey != null
                && firstKey.equals(secondKey));
    }

    private static class Pair<K, V> {
        private K key;
        private V value;
    }
}
