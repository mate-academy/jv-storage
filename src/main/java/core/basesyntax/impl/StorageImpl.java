package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_SIZE = 10;

    private static final int PRIME = 97;

    private final Pair<K, V>[] pairsArray;

    public StorageImpl() {
        pairsArray = new Pair[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> input = Pair.of(key, value);

        for (int i = 0; i < pairsArray.length; i++) {
            if (pairsArray[i] == null
                    || pairsArray[i].first == key
                    || pairsArray[i].first == null && key == null) {
                pairsArray[i] = input;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairsArray) {
            if (pair != null
                    && (pair.first == key
                    || pair.first != null
                    && pair.first.equals(key))) {
                return pair.second;
            }
        }
        return null;
    }

    private static class Pair<T, X> {
        private final T first;
        private final X second;

        private Pair(T first, X second) {
            this.first = first;
            this.second = second;
        }

        public static <T, X> Pair<T, X> of(T first, X second) {
            return new Pair<>(first, second);
        }

        public T getFirst() {
            return first;
        }

        public X getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }

            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) object;
            if (first == null && pair.first == null
                    || first != null && first.equals(pair.first)) {
                return true;
            }

            return second == null && pair.second == null
                    || second != null && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int hashCode = first != null ? first.hashCode() : 0;
            hashCode = second != null ? PRIME * hashCode + second.hashCode() : hashCode;
            return hashCode;
        }
    }
}