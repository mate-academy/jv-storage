package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final Pair<K, V>[] pairs;

    public StorageImpl() {
        pairs = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] == null) {
                pairs[i] = new Pair<>(key, value);
                return;
            } else if (pairs[i].hasKey(key)) {
                pairs[i].key = key;
                pairs[i].value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] == null) {
                continue;
            }
            if (pairs[i].hasKey(key)) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] != null) {
                size++;
            }
        }
        return size;
    }

    static class Pair<K, V> {
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

        public boolean hasKey(K input) {
            return (key == input)
                    || (key != null && key.equals(input));
        }
    }
}
