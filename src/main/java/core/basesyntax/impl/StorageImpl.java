package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Pair<K, V>[] storage = new Pair[DEFAULT_CAPACITY];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || (storage[i].getKey() != null
                    && storage[i].getKey().equals(key))) {
                storage[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>(key, value);
        storage[size++] = pair;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || (storage[i].getKey() != null
                    && storage[i].getKey().equals(key))) {
                return storage[i].getValue();
            }
        }
        return null;
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

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
