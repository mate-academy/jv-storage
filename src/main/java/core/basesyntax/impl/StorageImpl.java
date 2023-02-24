package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int storageCounter = 0;
    private int maxStorage = 10;
    private StorageImpl[] storages = new StorageImpl[maxStorage];

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        storages[storageCounter].key = key;
        storages[storageCounter].value = value;
        storageCounter++;
    }

    @Override
    public V get(K key) {
        V result = null;
        if (key != null) {
            for (int i = 0; i < maxStorage; i++) {
                if (storages[i].key.equals(key)) {
                    return (V) storages[i].value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageCounter;
    }
}
