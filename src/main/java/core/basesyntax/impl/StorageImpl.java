package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K key;
    private V value;
    private StorageImpl<K, V>[] storageArray;
    private int counter = 0;

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
        storageArray = new StorageImpl[10];
    }

    @Override
    public void put(K key, V value) {
        for (StorageImpl<K, V> storage : storageArray) {
            if (storage == null) {
                break;
            }
            if (storage.getKey() != null
                    && storage.getKey().equals(key)) {
                storage.setValue(value);
                return;
            }
        }
        StorageImpl<K, V> storage = new StorageImpl<>(key, value);
        storageArray[counter] = storage;
        counter++;
    }

    @Override
    public V get(K key) {
        if (counter == 0) {
            return null;
        }
        for (StorageImpl<K, V> storage : storageArray) {
            if (storage.getKey() == null) {
                if (key == null) {
                    return storage.getValue();
                }
                continue;
            }
            if (storage.getKey().equals(key)) {
                return storage.getValue();
            }
        }
        return null;
    }

    private K getKey() {
        return key;
    }

    private V getValue() {
        return value;
    }

    private void setValue(V value) {
        this.value = value;
    }
}
