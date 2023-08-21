package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_COUNT = 10;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        size = 0;
        pairs = new Pair[MAX_PAIRS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_PAIRS_COUNT) {
            throw new RuntimeException("You already have full storage");
        }
        Pair<K, V> pair = new Pair<>(key, value);
        if (!updatePair(pair)) {
            pairs[size] = pair;
            size++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(pairs[i].getKey(), key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean updatePair(Pair<K, V> pair) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(pairs[i].getKey(), pair.getKey())) {
                pairs[i] = pair;
                return true;
            }
        }
        return false;
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
