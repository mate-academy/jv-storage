package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private Pair<K, V>[] storage;

    public StorageImpl() {
        this.storage = new Pair[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (storage[i] == null) {
                storage[i] = new Pair<>(key, value);
                size++;
                return;
            } else if (compareKeys(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareKeys(K storageKey, K inputKey) {
        return (storageKey == inputKey
            || (storageKey != null && storageKey.equals(inputKey)));
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
