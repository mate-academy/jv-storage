package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_COUNT = 10;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_PAIRS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_PAIRS_COUNT) {
            throw new RuntimeException("You already have full storage");
        }
        Pair<K, V> pair = new Pair<>(key, value);
        int index = getIndexByKey(key);
        if (index == -1) {
            pairs[size++] = pair;
            return;
        }
        pairs[index] = pair;

    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index == -1 ? null : pairs[index].value;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            K pairKey = pairs[i].key;
            if (pairKey == key || pairKey != null && pairKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
