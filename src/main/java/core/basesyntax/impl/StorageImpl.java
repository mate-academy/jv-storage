package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final Pair<K, V>[] pairs;
    private int counter;

    public StorageImpl() {
        pairs = new Pair[SIZE_OF_ARRAY];
        counter = 0;
    }

    private boolean checkKey(Pair<K, V> pair, K key) {
        return (pair.getKey() != null && pair.getKey().equals(key)) || pair.getKey() == key;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (checkKey(pairs[i], key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[counter] = new Pair<>(key, value);
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (checkKey(pairs[i], key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
