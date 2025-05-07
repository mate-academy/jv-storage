package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_SIZE = 10;
    private int size;
    private Pair[] storage = new Pair[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        Pair pair = new Pair(key, value);
        int i = getIndex(key);
        if (i >= 0) {
            storage[i] = pair;
        } else {
            storage[size++] = pair;
        }
    }

    @Override
    public V get(K key) {
        int i = getIndex(key);
        return i >= 0 ? (V) storage[i].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].getKey() != null) && storage[i].getKey().equals(key)
                    || (storage[i].getKey() == null) && (key == null)) {
                return i;
            }
        }
        return -1;
    }

    private class Pair<K, V> {
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

}
