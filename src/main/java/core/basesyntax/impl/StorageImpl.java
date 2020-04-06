package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;

    private K key;
    private V value;
    private StorageImpl<K, V>[] storageArray;

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
        storageArray = new StorageImpl[SIZE];
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
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i] == null) {
                storageArray[i] = storage;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> storage : storageArray) {
            if (storage == null) {
                break;
            }
            if (storage.getKey() == null && key == null) {
                return storage.getValue();
            }
            if (storage.getKey() == null) {
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
