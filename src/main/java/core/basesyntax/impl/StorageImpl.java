package core.basesyntax.impl;

import core.basesyntax.DataAccess;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private DataAccess<K, V>[] storage;

    public StorageImpl() {
        storage = new DataAccess[MAX_ITEMS_NUMBER];
    }

    public DataAccess<K, V>[] getStorage() {
        return storage;
    }

    public void setStorage(DataAccess<K, V>[] storage) {
        this.storage = storage;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && (key == storage[i].getKey()
                    || key != null && key.equals(storage[i].getKey()))) {
                storage[i].setValue(value);
                return;
            } else if (storage[i] == null) {
                storage[i] = new DataAccess<>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (DataAccess<K, V> storageItem : storage) {
            if (storageItem != null && (key == storageItem.getKey()
                    || key != null && key.equals(storageItem.getKey()))) {
                return storageItem.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int storageSize = 0;
        for (DataAccess<K, V> storageItem : storage) {
            if (storageItem != null) {
                storageSize++;
            }
        }
        return storageSize;
    }
}
