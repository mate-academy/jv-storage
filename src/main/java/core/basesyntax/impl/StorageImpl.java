package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private KeyValuePair<K, V>[] storage;

    public StorageImpl() {
        storage = new KeyValuePair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                storage[i].setValue(value);
                return;
            }
        }

        KeyValuePair<K, V> keyValuePair = new KeyValuePair<>(key, value);

        if (size < MAX_SIZE) {
            storage[size++] = keyValuePair;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getKey() == key
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                return storage[i].getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
