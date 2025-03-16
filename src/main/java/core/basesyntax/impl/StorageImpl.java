package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;

    private Pair<K, V>[] pairs;
    private int size;

    public StorageImpl() {
        pairs = new Pair[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = getPair(key);
        if (pair != null) {
            pair.setValue(value);
            return;
        }

        pairs[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPair(key);
        if (pair != null) {
            return pair.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getPair(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair != null && Objects.equals(pair.getKey(), key)) {
                return pair;
            }
        }
        return null;
    }
}
