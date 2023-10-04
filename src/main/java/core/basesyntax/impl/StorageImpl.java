package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int ITEM_FIELDS = 2;
    private static final int KEY_COLUMN_INDEX = 0;
    private static final int VALUE_COLUMN_INDEX = 1;
    private static final int DEFAULT_STORAGE_SIZE = 0;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ITEMS_NUMBER];
        size = DEFAULT_STORAGE_SIZE;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyEquals(key, pairs[i].key)) {
                pairs[i].value = value;
                return;
            }
        }
        if (size < MAX_ITEMS_NUMBER) {
            pairs[size] = new Pair<>(key, value);
            size++;
        } else {
            throw new RuntimeException("Array is full. Cannot store more elements!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeyEquals(key, pairs[i].key)) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyEquals(K firstKey, K secondKey) {
        return firstKey == null ? secondKey == null : firstKey.equals(secondKey);
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
