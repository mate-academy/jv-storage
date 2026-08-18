package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int count;

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair<K, V>[] pairs = new Pair[MAX_ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; ++i) {
            if ((key == null ? pairs[i].key == null : key.equals(pairs[i].key))) {
                pairs[i].value = value;
                return;
            }
        }
        if (count < pairs.length) {
            pairs[count] = new Pair<>(key, value);
            count++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; ++i) {
            if ((key == null ? pairs[i].key == null : key.equals(pairs[i].key))) {
                return pairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
