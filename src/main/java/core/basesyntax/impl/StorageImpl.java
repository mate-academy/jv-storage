package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (pairs[i].key != null && pairs[i].key.equals(key)
                    || pairs[i].key == key) {
                pairs[i].value = value;
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (pairs[j].key != null && pairs[j].key.equals(key)
                    || pairs[j].key == key) {
                return pairs[j].value;
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

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
