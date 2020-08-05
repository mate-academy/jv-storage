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

        for (int i = 0; i <= size; i++) {
            if (i == size) {
                storageArray[i] = Pair.of(key, value);
                size++;
                return;
            }
            if (storageArray[i].firstVariable == key
                    || storageArray[i].equals(key)
                    && storageArray[i].firstVariable != null) {
                storageArray[i].secondVariable = value;
                return;
            }

        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K,V> pair = storageArray[i];
            if (pair.getFirst() == key
                    || pair.getFirst() != null && pair.getFirst().equals(key)) {
                return pair.getSecond();
            }
        }
        return null;
    }

    private static class Pair<T1, T2> {
        private T1 firstVariable;
        private T2 secondVariable;

        private Pair(T1 firstVariable, T2 secondVariable) {
            this.firstVariable = firstVariable;
            this.secondVariable = secondVariable;
        }

        public static <T1, T2> Pair<T1, T2> of(T1 firstVariable, T2 secondVariable) {
            return new Pair<>(firstVariable, secondVariable);
        }

        public T1 getFirst() {
            return firstVariable;
        }

        public T2 getSecond() {
            return secondVariable;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<T1, T2> pair = (Pair<T1, T2>) o;
            return (firstVariable == null || pair.firstVariable == null)
                    ? firstVariable == pair.firstVariable
                    : firstVariable.equals(pair.firstVariable)
                    && (secondVariable == null || pair.secondVariable == null)
                    ? secondVariable == pair.secondVariable
                    : secondVariable.equals(pair.secondVariable);
        }

        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;
            result += prime * result + (firstVariable == null ? 0 : firstVariable.hashCode());
            result += prime * result + (secondVariable == null ? 0 : secondVariable.hashCode());
            return result;
        }
    }
}
