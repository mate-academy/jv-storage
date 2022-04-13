package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] pairs;
    private int capacity;

    public StorageImpl() {
        pairs = new Pair[10];
    }

    @Override
    public void put(K key, V value) {
        if (capacity >= 10) {
            throw new RuntimeException("Storage is full");
        }

        for (int i = 0; i < pairs.length; i++) {

            if (Objects.nonNull(pairs[i]) &&
                    (Objects.isNull(pairs[i].getKey()) || pairs[i].getKey().equals(key))) {
                pairs[i].setValue(value);
                return;
            }

            if (Objects.isNull(pairs[i])) {
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
            if (Objects.nonNull(pr) && pr.equals(pair)) {
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
