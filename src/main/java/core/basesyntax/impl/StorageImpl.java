package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int currentSize;
    private final DataUnit<K, V>[] storage;

    public StorageImpl() {
        storage = new DataUnit[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (DataUnit<K, V> kvDataUnit : storage) {
            if (kvDataUnit != null && compareKeys(key, kvDataUnit.getKey())) {
                kvDataUnit.setValue(value);
                break;
            }
            if (kvDataUnit == null) {
                storage[currentSize] = new DataUnit<>(key, value);
                currentSize++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i] != null && compareKeys(key, storage[i].getKey())) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean compareKeys(K firstKey, K secondKey) {
        return (firstKey == secondKey)
                || (secondKey != null && secondKey.equals(firstKey));
    }
}
