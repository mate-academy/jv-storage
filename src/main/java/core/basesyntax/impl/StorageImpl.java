package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Pair<K,V>[] pair;
    private int size;

    public StorageImpl() {
        this.pair = new Pair[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (pair[i].key != null && pair[i].key.equals(key) || pair[i].key == key) {
                pair[i].value = value;
                return;
            }
        }
        pair[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (pair[i].key != null && pair[i].key.equals(key) || pair[i].key == key) {
                return pair[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
