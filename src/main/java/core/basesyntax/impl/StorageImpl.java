package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MASS_LENGTH = 10;
    private Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        this.storage = new Pair[MASS_LENGTH];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].equals(key)
                    || i == size || storage[i].key == key) {
                storage[i] = Pair.of(key, value);
                size = size == i ? size + 1 : size;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (pair != null && (pair.key != null && pair.key.equals(key) || pair.key == key)) {
                return pair.value;
            }
        }
        return null;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static <K, V> Pair<K, V> of(K first, V value) {
            return new Pair<>(first, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key == null ? key == pair.key : key.equals(pair.key)
                    && value == null ? value == pair.value : value.equals(pair.value);
        }

        @Override
        public int hashCode() {
            int primaryNumber = 17;
            return ((primaryNumber * 7 + (key == null ? 0 : key.hashCode()))
                    * 7 + (value == null ? 0 : value.hashCode()));
        }
    }
}
