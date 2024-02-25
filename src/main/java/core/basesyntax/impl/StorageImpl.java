package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private Data[] storage;
    private int freeIndex;

    public StorageImpl() {
        this.storage = new Data[MAX_STORAGE_LENGTH];
        this.freeIndex = 0;
    }

    public Data[] getStorage() {
        return storage;
    }

    @Override
    public void put(K key, V value) {
        Data newData = new Data(key, value);

        for (int i = 0; i < MAX_STORAGE_LENGTH; i++) {
            if (key == null && storage[i] != null && storage[i].getKey() == null
                    || (storage[i] != null
                    && storage[i].getKey() != null
                    && storage[i].getKey().equals(key))
            ) {
                storage[i].setValue(value);
                return;
            }
        }

        if (freeIndex == MAX_STORAGE_LENGTH) {
            throw new RuntimeException(
                    "The storage is totally filled - impossible to add new data"
            );
        } else {
            storage[freeIndex] = newData;
            freeIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if ((key == null && storage[i] != null && storage[i].getKey() == null)
                    || (storage[i] != null
                    && storage[i].getKey() != null
                    && storage[i].getKey().equals(key))
            ) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < MAX_STORAGE_LENGTH; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }
}
