package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair[] pairs = new Pair[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i].getKey() || key != null && key.equals(pairs[i].getKey())) {
                pairs[i].setValue(value);
                return;
            }
        }
        pairs[size++] = new Pair().setValue(value).setKey(key);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pairs[i].getKey() || key != null && key.equals(pairs[i].getKey())) {
                return (V) pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
