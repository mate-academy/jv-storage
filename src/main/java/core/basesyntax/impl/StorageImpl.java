package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size;
    @SuppressWarnings("unchecked")
    private final Pair<K, V>[] pairs = new Pair[10];

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private boolean keyEquals(K key) {
            if (this == key) {
                return true;
            }
            return (this.key == null && key == null) || (this.key != null && this.key.equals(key));
        }
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            pairs[size] = new Pair<>(key, value);
            size++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (pairs[i].keyEquals(key)) {
                pairs[i].value = value;
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (pairs[i] == null) {
                return null;
            }
            if (pairs[i].keyEquals(key)) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}

