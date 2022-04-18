package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] pairs = new Pair[MAX_ITEMS_NUMBER];

    public static class Pair<K, V> {
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
        int flagKey = 0;
        for (Pair<K, V> pair : pairs) {
            if (pair != null
                    && (pair.key != null && pair.key.equals(key)
                    || (pair.key == null && key == null))) {
                flagKey = 1;
                pair.value = value;
                break;
            }
        }
        if (flagKey == 0) {
            int flagPair = 0;
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[j] == null) {
                    flagPair = 1;
                    pairs[j] = new Pair<>(key, value);
                    break;
                }
            }
            if (flagPair == 0) {
                System.out.println("The Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if ((pair != null)
                    && (pair.key != null && pair.key.equals(key)
                    || pair.key == null && key == null)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Pair<K, V> pair : pairs) {
            if (pair != null) {
                count++;
            }
        }
        return count;
    }
}
