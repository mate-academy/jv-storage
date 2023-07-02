package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        this.pairs = (Pair<K, V>[]) new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquals(pairs[i].getKey(), key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEquals(pairs[i].getKey(), key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(Object firstOne, Object secondOne) {
        return (firstOne == secondOne || firstOne != null && firstOne.equals(secondOne));
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
