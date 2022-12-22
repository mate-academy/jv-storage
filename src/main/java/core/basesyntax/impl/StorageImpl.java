package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;

    private Pair<K, V>[] pairs = new Pair[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        Pair<K, V> ourPair = new Pair<>(key, value);

        for (int i = 0; i < MAX_SIZE; i++) {
            if (pairs[i] == null) {
                pairs[i] = ourPair;
                size++;
                return;
            }
            if (ourPair.getKey() == null) {
                if (pairs[i].getKey() == null) {
                    pairs[i].setValue(value);
                    return;
                }
            } else {
                if (ourPair.getKey().equals(pairs[i].getKey())) {
                    pairs[i].setValue(value);
                    return;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (pairs[i].getKey() == null) {
                    return pairs[i].getValue();
                }
            } else {
                if (key.equals(pairs[i].getKey())) {
                    return pairs[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
