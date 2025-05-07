package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Pair<K, V>[]storage;
    private int size;

    public StorageImpl() {
        storage = (Pair<K, V>[]) new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == storage[i].key || key != null && key.equals(storage[i].key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storage[i].key || key != null && key.equals(storage[i].key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
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
