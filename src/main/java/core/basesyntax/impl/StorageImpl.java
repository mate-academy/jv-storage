package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int SIZE = 10;
    private Pair<K, V>[] pairs;

    public StorageImpl() {
        this.pairs = new Pair[SIZE];
    }

    @Override
    public void put(Object key, Object value) {
        for (int i = 0; i < SIZE; i++) {
            if (null == pairs[i] || isTheSameKey(pairs[i], key)) {
                pairs[i] = Pair.of(key, value);
                break;
            }
        }
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < SIZE; i++) {
            if (pairs[i] != null && isTheSameKey(pairs[i], key)) {
                return pairs[i].getSecond();
            }
        }
        return null;
    }

    private boolean isTheSameKey(Pair pair, Object key) {
        return pair.getFirst() == key
                || (pair.getFirst() != null && pair.getFirst().equals(key));
    }

    static class Pair<T, K> {
        static final int CONSTANT = 31;

        private T first;
        private K second;

        private Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public static <T, K> Pair of(T data, K data2) {
            return new Pair<T, K>(data, data2);
        }

        public T getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }
    }
}
