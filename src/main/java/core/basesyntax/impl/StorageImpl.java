package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_OF_ELEMENTS = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ITEMS_OF_ELEMENTS];
    }

    public static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }

    private Pair<K, V> getPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (pairs[i].key == key || (pairs[i].key != null && pairs[i].key.equals(key))) {
                return pairs[i];
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = getPairByKey(key);
        if (pair == null) {
            pairs[size++] = new Pair<>(key, value);
        } else {
            pair.value = value;
        }
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPairByKey(key);
        return pair == null ? null : pair.getValue();
    }

    @Override
    public int size() {
        return size;
    }
}
