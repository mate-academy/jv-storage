package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Pair<K, V>[] pairs = new Pair[MAX_ITEMS_NUMBER];
    private int size;

    private class Pair<K,V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        Pair pair = getPairByKey(key);
        if (pair == null) {
            pairs[size++] = new Pair<>(key, value);
        } else {
            pair.value = value;
        }
    }

    private Pair getPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (pairs[i].key == key || (pairs[i].key != null && pairs[i].key.equals(key))) {
                return pairs[i];
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        Pair pair = getPairByKey(key);
        return pair == null ? null : (V) pair.value;
    }

    @Override
    public int size() {
        return size;
    }
}
