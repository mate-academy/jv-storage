package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final Pair[] pairs = new Pair[STORAGE_SIZE];
    private int size;

    public StorageImpl() {
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = getPairFromKey(key);
        if (pair != null) {
            pair.setValue(value);
            return;
        }

        Pair pair1 = new Pair(key, value);
        pairs[size] = pair1;
        size++;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPairFromKey(key);
        if (pair != null) {
            return pair.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getPairFromKey(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> pair = pairs[i];
            if (pair.getKey() == key || pair.getKey() != null && pair.getKey().equals(key)) {
                return pair;
            }
        }
        return null;
    }
}
