package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;

    private Pair<K, V>[] storage;
    private int indexFreePosition;

    public StorageImpl() {
        storage = new Pair[ARRAY_LENGTH];
        indexFreePosition = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < indexFreePosition; i++) {
            if (storage[i].getKey() == key
                    || storage[i].getKey() != null
                    && storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }
        try {
            storage[indexFreePosition] = new Pair<>(key, value);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("In array not enough"
                    + " space for this operation", e);
        }
        indexFreePosition++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < indexFreePosition; i++) {
            if (storage[i].getKey() == key
                    || storage[i].getKey() != null
                    && storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexFreePosition;
    }
}
