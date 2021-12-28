package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K, V>[] pairs;

    public StorageImpl() {
        pairs = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (key == null && pairs[i].getKey() == null
                    || pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[size()] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && pairs[i].getKey() == null
                    || pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
