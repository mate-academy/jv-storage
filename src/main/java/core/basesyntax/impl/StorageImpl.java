package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Pair<K, V>[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        elements = (Pair<K, V>[]) new Pair[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = getPair(key);
        if (pair != null) {
            pair.value = value;
            return;
        }
        if (size > elements.length - 1) {
            throw new RuntimeException("Storage capacity reached. Unable to add any more elements");
        }
        elements[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPair(key);
        return pair == null ? null : pair.value;
    }

    @Override
    public int size() {
        return size;
    }

    private class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair<K, V> getPair(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> pair = elements[i];
            if (pair.key == key || pair.key != null && pair.key.equals(key)) {
                return pair;
            }
        }
        return null;
    }
}
