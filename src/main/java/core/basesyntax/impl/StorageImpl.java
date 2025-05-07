package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Can't put new pair. Too many elements in storage");
        }
        for (int i = 0; i < size; i++) {
            if (pairs[i].isKeysEqual(key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> e : pairs) {
            if (e != null && e.isKeysEqual(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private final K key;
        private V value;

        public Pair(K number, V value) {
            this.key = number;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isKeysEqual(K key) {
            int thisHash = (this.key == null) ? 0 : this.key.hashCode();
            int currentHash = (key == null) ? 0 : key.hashCode();
            return thisHash == currentHash;
        }
    }
}
