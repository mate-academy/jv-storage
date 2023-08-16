package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] pairs;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        pairs = (Pair<K, V>[]) new Pair[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(key, pairs[i].getKey())) {
                pairs[i].setValue(value);
                return;
            }
        }
        if (size == pairs.length) {
            increaseCapacity();
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(key, pairs[i].getKey())) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareKeys(Object obj1, Object obj2) {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        int newCapacity = pairs.length * 2;
        Pair<K, V>[] newPairs = (Pair<K, V>[]) new Pair[newCapacity];
        System.arraycopy(pairs, 0, newPairs, 0, size);
        pairs = newPairs;
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

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
