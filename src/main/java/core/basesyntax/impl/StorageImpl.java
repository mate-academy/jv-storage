package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private final Pair[] pairs;
    private int size;

    public StorageImpl() {
        this.pairs = new Pair[MAX_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> existingStorageItem = getStorageItemByKey(key);
        if (existingStorageItem != null) {
            existingStorageItem.value = value;
            return;
        }
        Pair<K, V> storageItem = new Pair<>(key, value);
        if (size == pairs.length) {
            throw new RuntimeException("Storage is FULL, you can't add new pair");
        }
        pairs[size] = storageItem;
        size++;
    }

    @Override
    public V get(K key) {
        Pair<K, V> existingStorageItem = getStorageItemByKey(key);
        if (existingStorageItem != null) {
            return existingStorageItem.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getStorageItemByKey(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null) {
                if (pair.key == key || (pair.key != null && pair.key.equals(key))) {
                    return pair;
                }
            }
        }
        return null;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
