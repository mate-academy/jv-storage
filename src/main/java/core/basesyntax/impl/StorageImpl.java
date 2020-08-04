package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private final Pair<K, V>[] pairs;
    private int index;

    public StorageImpl() {
        pairs = new Pair[ARRAY_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyHashCode = key == null ? 0 : key.hashCode();
        for (int i = 0; i < index; i++) {
            int pairKeyHashCode = pairs[i].getKey() == null ? 0 : pairs[i].getKey().hashCode();
            if (keyHashCode == pairKeyHashCode) {
                pairs[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = Pair.of(key, value);
        pairs[index] = pair;
        index += 1;
    }

    @Override
    public V get(K key) {
        int keyHashCode = key == null ? 0 : key.hashCode();
        for (int i = 0; i < index; i++) {
            int pairKeyHashCode = pairs[i].getKey() == null ? 0 : pairs[i].getKey().hashCode();
            if (keyHashCode == pairKeyHashCode) {
                return pairs[i].getValue();
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

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return (key != null ? key.equals(pair.key) : pair.key == null)
                    && (value != null ? value.equals(pair.value) : pair.value == null);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (key != null ? key.hashCode() : 0);
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        public static <K, V> Pair of(K key, V value) {
            return new Pair(key, value);
        }
    }
}


