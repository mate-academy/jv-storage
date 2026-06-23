package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private record Bucket<K, V>(K key, V value) {}

    private final Bucket<K, V>[] storage;
    private int filled;

    public StorageImpl() {
        storage = (Bucket<K, V>[]) new Bucket[10];
        filled = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < filled; i++) {
            if (isSameKey(storage[i].key(), key)) {
                storage[i] = new Bucket<>(key, value);
                return;
            }
        }

        storage[filled] = new Bucket<>(key, value);
        filled++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < filled; i++) {
            if (isSameKey(storage[i].key(), key)) {
                return storage[i].value();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return filled;
    }

    private boolean isSameKey(K storedKey, K inputKey) {
        if (storedKey == null && inputKey == null) {
            return true;
        }

        if (storedKey == null || inputKey == null) {
            return false;
        }

        return storedKey.equals(inputKey);
    }
}
