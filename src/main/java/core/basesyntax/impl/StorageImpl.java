package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private final Pair<K, V>[] pairs = new Pair[10];

    public void put(K key, V value) {
        Pair<K, V> tempPair = findPairByKey(key);
        if (tempPair == null) {
            pairs[size++] = new Pair<>(key, value);
            return;
        }
        tempPair.setValue(value);
    }

    private Pair<K, V> findPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (isConditionTrue(key, i)) {
                return pairs[i];
            }
        }
        return null;
    }

    private boolean isConditionTrue(K key, int i) {
        return pairs[i].getKey() != null && pairs[i].getKey().equals(key)
                || pairs[i].getKey() == null && key == null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> resultOfGet = findPairByKey(key);
        return resultOfGet != null ? resultOfGet.getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public int hashCode() {
            return 31 * (key == null ? 0 : key.hashCode())
                    + 17 * (value == null ? 0 : value.hashCode());
        }

        public void setValue(V value) {
            this.value = value;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair<K, V> pair = (Pair) obj;
            return isKeyValueEquals(pair);
        }

        private <K, V> boolean isKeyValueEquals(Pair<K, V> pair) {
            return (pair.getKey() == key
                    || (pair.getKey() != null && pair.getKey().equals(key)))
                    && (pair.getValue() == value
                    || (pair.getValue() != null && pair.getValue().equals(value)));
        }
    }
}
