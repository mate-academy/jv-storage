package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int storageSize = 0;
    private StorageImpl<K, V>[] storageBefore = new StorageImpl[1];

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        storageSize++;
        StorageImpl<K, V>[] newStorage = new StorageImpl[storageSize];
        newStorage[storageSize - 1] = new StorageImpl<>(key, value);
        if (storageSize == 1) {
            storageBefore[0] = newStorage[0];
        } else {
            for (StorageImpl<K, V> element : storageBefore) {
                if (element.keyEquals(key)) {
                    element.value = value;
                    storageSize--;
                    return;
                }
            }
            for (int i = 0; i < storageBefore.length; i++) {
                newStorage[i] = storageBefore[i];
            }
            storageBefore = newStorage;
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> element : storageBefore) {
            if (element == null) {
                return null;
            }
            if (element.keyEquals(key)) {
                return element.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private boolean keyEquals(K key) {
        if (this == key) {
            return true;
        }
        return (this.key == null && key == null) || (this.key != null && this.key.equals(key));
    }
}

