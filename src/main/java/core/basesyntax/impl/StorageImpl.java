package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private Pair<K, V>[] pairs;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        pairs = (Pair<K, V>[]) new Pair[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);

        if (index != -1) {
            pairs[index] = new Pair<>(key, value);
            return;
        }

        if (size >= MAX_SIZE) {
            throw new IllegalStateException("Storage is full");
        }

        pairs[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index == -1 ? null : pairs[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(pairs[i].getKey(), key)) {
                return i;
            }
        }
        return -1;
    }
}


