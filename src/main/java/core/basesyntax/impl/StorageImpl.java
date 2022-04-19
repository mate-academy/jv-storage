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

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
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
        for (int i = 0; i < size; i++) {
            if (pairs[i] != null
                    && (pairs[i].key != null && pairs[i].key.equals(key)
                    || pairs[i].key == key)) {
                pairs[i].value = value;
                return;
            }
        }
        if (size == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("The Storage is full");
        } else {
            pairs[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (pairs[j] != null
                    && (pairs[j].key != null && pairs[j].key.equals(key)
                    || pairs[j].key == key)) {
                return pairs[j].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
