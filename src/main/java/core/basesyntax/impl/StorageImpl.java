package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int SIZE_OF_ARRAY = 10;
    private Pair[] pairs = new Pair[SIZE_OF_ARRAY];
    private int counter = 0;

    private boolean checkKey(Pair pair, K key) {
        return (pair != null && pair.getKey() == key)
                || pair.getKey() != null && pair.getKey().equals(key);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (checkKey(pairs[i], key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[counter] = new Pair(key, value);
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (checkKey(pairs[i], key)) {
                return (V) pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
