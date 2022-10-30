package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY_OF_STORAGE = 10;
    private StorageImpl<K, V>[] storages;
    private K key;
    private V value;
    private int countOfElements;

    public StorageImpl() {
        storages = new StorageImpl[CAPACITY_OF_STORAGE];
        countOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isSameKey = false;
        for (int i = 0; i < countOfElements; i++) {
            if (storages[i].key == key || storages[i].key != null && storages[i].key.equals(key)) {
                storages[i].value = value;
                isSameKey = true;
            }
        }
        if (!isSameKey) {
            StorageImpl<K, V> storage = new StorageImpl<>();
            storage.key = key;
            storage.value = value;
            storages[countOfElements] = storage;
            countOfElements++;
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> storage : storages) {
            if (storage == null) {
                return null;
            } else if (storage.key == key || storage.key != null && storage.key.equals(key)) {
                return storage.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return countOfElements;
    }
}
