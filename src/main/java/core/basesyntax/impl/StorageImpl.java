package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K, V>[] pairs = new Pair[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        Pair<K, V> ourPair = new Pair<>(key, value);
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] == null) {
                pairs[i] = ourPair;
                size++;
                return;
            }
            if (areKeysEquals(ourPair.getKey(), pairs[i].getKey())) {
                pairs[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEquals(key, pairs[i].getKey())) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEquals(K first, K second) {
        return first == second || (first != null && first.equals(second));
    }

    private static class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key,V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object pair) {
            if (pair == this) {
                return true;
            }
            if (pair == null) {
                return false;
            }
            if (pair.getClass().equals(Pair.class)) {
                Pair current = (Pair) pair;
                return this.getKey().equals(current.getKey())
                        && this.getValue().equals(current.getValue());
            }
            return false;
        }

        public int hashCode() {
            int result = 17;
            result = 31 + (key == null ? 0 : key.hashCode());
            result = 31 + (value == null ? 0 : value.hashCode());
            return result;
        }
    }
}
