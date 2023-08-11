package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Pair<K, V>[] pairs;
    private int size = 0;

    public StorageImpl() {
        pairs = new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && pairs[i].getKey() == null) {
                pairs[i] = new Pair<>(null, value);
                return;
            }
            if (pairs[i].getKey() == null) {
                continue;
            }
            if (pairs[i].getKey().equals(key)) {
                pairs[i] = new Pair<>(key, value);
                return;
            }
        }
        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Pair<K, V> pair = pairs[i];
            if (pair.getKey() == key || pair.getKey() != null && pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
