package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_SIZE = 10;
    private final Pair<K, V>[] pairsArray;
    private int currentAmount;

    public StorageImpl() {
        pairsArray = new Pair[MAXIMUM_SIZE];
    }

    public int getCurrentAmount() {
        return this.currentAmount;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> input = Pair.of(key, value);

        for (int i = 0; i < currentAmount; i++) {
            if ((pairsArray[i].first == key
                    || key != null && key.equals(pairsArray[i].first))) {
                pairsArray[i] = input;
                return;
            }
        }
        pairsArray[currentAmount] = input;
        currentAmount++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentAmount; i++) {
            Pair<K, V> pair = pairsArray[i];
            if (pair.first == key
                    || key != null && key.equals(pair.first)) {
                return pair.second;
            }
        }
        return null;
    }

    private static class Pair<K, V> {
        private static final int PRIME = 97;
        private K first;
        private V second;

        private Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public static <K, V> Pair<K, V> of(K first, V second) {
            return new Pair<>(first, second);
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
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

            Pair<K, V> pair = (Pair<K, V>) object;
            boolean checkOfFirst = first == pair.first
                    || first != null && first.equals(pair.first);
            boolean checkOfSecond = second == pair.second
                    || second != null && second.equals(pair.second);

            return checkOfFirst && checkOfSecond;
        }

        @Override
        public int hashCode() {
            int hashCode = first != null ? PRIME * first.hashCode() : 0;
            return second != null ? second.hashCode() + hashCode : hashCode;
        }
    }
}
