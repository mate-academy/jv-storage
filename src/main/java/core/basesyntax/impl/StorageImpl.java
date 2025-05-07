package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Pair<K, V>[] pairs;
    private int capacity;

    public StorageImpl() {
        pairs = new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (capacity >= 10) {
            throw new RuntimeException("Storage is full");
        }

        for (int i = 0; i < pairs.length; i++) {

            if (pairs[i] != null) {
                if ((pairs[i].getKey() == null) && key == null) {
                    pairs[i].setValue(value);
                    return;
                }
                if (pairs[i].getKey() != null) {
                    if (pairs[i].getKey().equals(key)) {
                        pairs[i].setValue(value);
                        return;
                    }
                }
            }

            if (pairs[i] == null) {
                Pair<K, V> pair = new Pair<>(key, value);
                pairs[i] = pair;
                ++capacity;
                return;
            }
        }
    }

    @Override
    public V get(K key) {

        Pair<K, Object> pair = new Pair<>(key, null);

        for (Pair<K, V> pr : pairs) {
            if (pr != null && pr.equals(pair)) {
                return pr.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return capacity;
    }
}
