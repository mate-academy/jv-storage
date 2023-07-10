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
        int indexOfPair = getIndexByKey(key);
        if (indexOfPair != -1) {
            storage[indexOfPair] = pair;
        } else {
            storage[indexOfNextPair] = pair;
            indexOfNextPair++;
        }
    }

    @Override
    public V get(K key) {
        return getIndexByKey(key) != -1 ? storage[getIndexByKey(key)].getValue() : null;
    }

    @Override
    public int size() {
        return indexOfNextPair;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size(); i++) {
            K storageKey = storage[i].getKey();
            if ((storageKey == null && key == null)
                    || (storageKey != null && storageKey.equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
