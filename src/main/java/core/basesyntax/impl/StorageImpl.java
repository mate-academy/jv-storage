package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_STORAGE_SIZE = 2;
    private static final int MULTIPLIER_STORAGE_SIZE = 2;
    private int size;
    private Pair<K, V>[] storage = new Pair[INITIAL_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        boolean hasEqualKey = false;

        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == null ? key == null : storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }

        if (size >= storage.length) {
            resize();
        }

        storage[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; ++i) {
            if (storage[i].getKey() == null ? key == null : storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Pair<K, V>[] newPairStorage = new Pair[storage.length * MULTIPLIER_STORAGE_SIZE];
        System.arraycopy(storage, 0, newPairStorage, 0, size);
        storage = newPairStorage;
    }
}
