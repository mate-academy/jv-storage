package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.exeptions.StorageException;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_STORAGE_LENGTH = 10;
    private Pair<K, V>[] storage;

    public StorageImpl() {
        this.storage = new Pair[0];
    }

    @Override
    public void put(K key, V value) {
        for (Pair pair : storage) {
            Object pairKey = pair.getKey();
            if (Objects.equals(pairKey, key)) {
                pair.setValue(value);
                return;
            }
        }
        if (storage.length >= MAXIMUM_STORAGE_LENGTH) {
            throw new StorageException("Storage is out of capacity");
        }
        Pair<K, V>[] newStorage = createCopyOfStorageWithIncreasedCapacity(storage);
        newStorage[newStorage.length - 1] = new Pair<>(key, value);
        this.storage = newStorage;
    }

    private Pair<K, V>[] createCopyOfStorageWithIncreasedCapacity(Pair<K, V>[] previousStorage) {
        Pair<K, V>[] newStorage = new Pair[previousStorage.length + 1];
        System.arraycopy(previousStorage, 0, newStorage, 0, previousStorage.length);
        return newStorage;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            K pairKey = pair.getKey();
            if (Objects.equals(pairKey, key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.length;
    }
}
