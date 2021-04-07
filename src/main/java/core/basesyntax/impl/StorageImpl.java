package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private final DataUnit<K, V>[] storage;

    public StorageImpl() {
        storage = new DataUnit[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && compareKeys(key, storage[i].getKey())) {
                storage[i].setValue(value);
                return;
            }
            if (storage[i] == null) {
                storage[i] = new DataUnit<>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (DataUnit<K, V> kvDataUnit : storage) {
            if (kvDataUnit != null && compareKeys(key, kvDataUnit.getKey())) {
                return kvDataUnit.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int result = 0;
        for (DataUnit<K, V> kvDataUnit : storage) {
            if (kvDataUnit != null) {
                result++;
            }
        }

        return result;
    }

    private boolean compareKeys(K firstKey, K secondKey) {
        return (firstKey == secondKey)
                || (secondKey != null && secondKey.equals(firstKey));
    }
}
