package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Pair<K, V>[] pairs;
    private int index;

    public StorageImpl() {
        pairs = new Pair[ARRAY_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = Pair.of(key, value);
        for (int i = 0; i < index; i++) {
            if (comparisonKeys(key, pairs[i].getKey())) {
                pairs[i] = pair;
                return;
            }
        }
        pairs[index++] = pair;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (comparisonKeys(key, pairs[i].getKey())) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    private boolean comparisonKeys(K firstKey, K secondKey) {
        return firstKey != null ? firstKey.equals(secondKey) : secondKey == null;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public static <K, V> Pair of(K key, V value) {
            return new Pair(key, value);
        }
    }
}
