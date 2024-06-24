package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_STORAGE_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        int i = 0;
        for (Pair<K, V> pair : storage) {
            if (pair != null && keyEquals(key, pair.getKey())) {
                storage[i] = new Pair<>(key, value);
                return;
            }
            i++;
        }
        storage[size] = new Pair<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (pair != null && keyEquals(key, pair.getKey())) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean keyEquals(K key, K pairKey) {
        return Objects.equals(pairKey, key);
    }
}
