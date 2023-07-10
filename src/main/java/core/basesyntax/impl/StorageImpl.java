package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;
    private Pair<K, V>[] storage;
    private int indexOfNextPair = 0;

    public class Pair<K, V> {
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
    }

    public StorageImpl() {
        storage = new Pair[ARRAY_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        int indexOfPair = getIndexOfPair(key);
        if (indexOfPair != -1) {
            storage[indexOfPair] = pair;
        } else {
            storage[indexOfNextPair] = pair;
            indexOfNextPair++;
        }
    }

    @Override
    public V get(K key) {
        return getIndexOfPair(key) != -1 ? storage[getIndexOfPair(key)].getValue() : null;
    }

    @Override
    public int size() {
        return indexOfNextPair;
    }

    private int getIndexOfPair(K key) {
        for (int i = 0; i < size(); i++) {
            if ((storage[i].getKey() == null && key == null)
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
