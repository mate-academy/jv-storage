package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ITEMS_NUMBER];
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return ((getKey() == pair.getKey())
                    || (!(getKey() == null) && getKey().equals(pair.getKey())))
                    && ((getValue() == pair.getValue())
                    || (!(getValue() == null) && getValue().equals(pair.getValue())));
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (getKey() == null ? 0 : getKey().hashCode());
            result = 31 * result + (getValue() == null ? 0 : getValue().hashCode());
            return result;
        }
    }

    @Override
    public void put(K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null
                    && (pair.key != null && pair.key.equals(key)
                    || pair.key == key)) {
                pair.value = value;
                return;
            }
        }
        for (int j = 0; j < pairs.length; j++) {
            if (pairs[j] == null) {
                pairs[j] = new Pair<>(key, value);
                size++;
                return;
            }
        }
        if (size == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("The Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null
                    && (pair.key != null && pair.key.equals(key)
                    || pair.key == key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
