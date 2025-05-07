package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private int currentIndex = 0;
    private Object[] storage;

    public StorageImpl() {
        storage = new Object[INITIAL_ARRAY_SIZE * 2];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentIndex * 2; i += 2) {
            if ((key == null) ? (storage[i] == null) : (key.equals(storage[i]))) {
                storage[i + 1] = value;
                return;
            }
        }

        storage[currentIndex * 2] = key;
        storage[currentIndex * 2 + 1] = value;
        currentIndex++;

        if (currentIndex == storage.length / 2) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentIndex * 2; i += 2) {
            if ((key == null) ? (storage[i] == null) : (key.equals(storage[i]))) {
                return (V) storage[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentIndex;
    }
}
