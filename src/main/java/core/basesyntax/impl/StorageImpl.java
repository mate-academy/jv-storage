package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] pairs = new Pair[0];

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        if (pairs.length == 0) {
            pairs = new Pair[1];
            pairs[0] = pair;
            return;
        }
        if (get(key) == null) {
            pairs = generateNewArray(pair, pairs);
            return;
        }
        updatePair(pair);
    }

    private Pair<K, V>[] generateNewArray(Pair<K, V> newPair, Pair<K, V>[] oldPairs) {
        Pair<K, V>[] newPairs = new Pair[oldPairs.length + 1];
        System.arraycopy(oldPairs, 0, newPairs, 0, oldPairs.length);
        newPairs[newPairs.length - 1] = newPair;
        return newPairs;
    }

    private void updatePair(Pair<K, V> pair) {
        for (int i = 0; i < pairs.length; i++) {
            if (Objects.equals(pairs[i].getKey(), pair.getKey())) {
                pairs[i] = pair;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (Objects.equals(pair.getKey(), key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return pairs.length;
    }

    private class Pair<K, V> {
        private K key;
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
    }
}
