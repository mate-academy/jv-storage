package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private final Pair<K,V>[] storageArray;

    private int size;

    public StorageImpl() {
        storageArray = new Pair[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = Pair.of(key, value);
        for (int i = 0; i < MAX_SIZE; i++) {
            if (i == size || storageArray[i].getFirst() == key
                    || storageArray[i] != null && storageArray[i].equals(key)) {
                storageArray[i] = pair;
                if (size == i) {
                    size++;
                }
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storageArray) {
            if (pair != null && (pair.getFirst() == key
                    || pair.getFirst() != null && pair.getFirst().equals(key))) {
                return pair.getSecond();
            }
        }
        return null;
    }

    private static class Pair<T1, T2> {
        private T1 t1;
        private T2 t2;

        private Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public static <T1, T2> Pair<T1, T2> of(T1 t1, T2 t2) {
            return new Pair<>(t1, t2);
        }

        public T1 getFirst() {
            return t1;
        }

        public T2 getSecond() {
            return t2;
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
            return (this.getFirst() == null || pair.getFirst() == null)
                    ? this.getFirst() == pair.getFirst()
                    : this.getFirst().equals(pair.getFirst())
                    && (this.getSecond() == null || pair.getSecond() == null)
                    ? this.getSecond() == pair.getSecond()
                    : this.getSecond().equals(pair.getSecond());
        }

        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;
            result += prime * result + (t1 == null ? 0 : t1.hashCode());
            result += prime * result + (t2 == null ? 0 : t2.hashCode());
            return result;
        }
    }
}
