package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private KeyValue<K, V>[] storage;

    public StorageImpl() {
        storage = new KeyValue[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if ((storage[i].getKey() == null && key == null)
                        || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                    storage[i].setValue(value);
                    return;
                }
            }
        }

        KeyValue<K, V> keyValue = new KeyValue<>(key, value);

        if (size < MAX_SIZE) {
            storage[size++] = keyValue;
        }
    }

    @Override
    public V get(K key) {
        if (size == 0) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if ((storage[i].getKey() == null && key == null)
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
