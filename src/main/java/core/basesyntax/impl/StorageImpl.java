package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_CAPACITY = 10;

    private final Pair<K, V>[] storageArray;

    public StorageImpl() {
        storageArray = new Pair[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = Pair.of(key, value);
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i] == null || storageArray[i].first == key
                    || storageArray[i].equals(key)) {
                storageArray[i] = pair;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storageArray) {
            if (pair != null && (pair.first == key
                    || pair.first != null && pair.first.equals(key))) {
                return pair.second;
            }
        }
        return null;
    }

    private static class Pair<T, U> {
        private final T first;
        private final U second;

        private Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public static <T, U> Pair<T, U> of(T first, U second) {
            return new Pair<>(first, second);
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return (first == pair.first || (first != null && first.equals(pair.first)))
                   && (second == pair.second || (second != null && second.equals(pair.second)));
        }

        @Override
        public int hashCode() {
            int hash = first == null ? 0 : first.hashCode();
            hash = second == null ? hash : hash * 31 + second.hashCode();
            return hash;
        }
    }
}
