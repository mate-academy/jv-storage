package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private Pair<K, V>[] pair;
    private int size;

    public StorageImpl() {
        pair = new Pair[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pairPut = findPair(key);
        if (pairPut == null) {
            Pair<K, V> pairToPut = new Pair<K, V>(key, value);
            pair[size] = pairToPut;
            size++;
        } else {
            pairPut.setValue(value);
        }
    }

    private Pair<K, V> findPair(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> pairCurrent = pair[i];
            if (pair[i] != null && (pairCurrent.getKey() != null
                    && pairCurrent.getKey().equals(key) || (pairCurrent.getKey() == null)
                    && (key == null))) {
                return pairCurrent;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pairGet = findPair(key);
        if (pairGet != null) {
            return pairGet.getValue();
        } else {
            return null;
        }
    }

    @Override
    public int size() {

        return size;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
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
