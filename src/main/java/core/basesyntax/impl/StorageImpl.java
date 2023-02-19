package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    private final Pair<K, V>[] storage;

    public StorageImpl() {
        storage = new Pair[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> toSave = new Pair<>(key, value);
        int position = findExistingPositionByKey(key);
        if (position != -1) {
            storage[position] = toSave;
        } else {
            position = findFreeSpace();
            if (position != -1) {
                storage[position] = toSave;
            } else {
                throw new ArrayStoreException("Storage is out of free space!");
            }
        }
    }

    @Override
    public V get(K key) {
        int position = findExistingPositionByKey(key);
        if (position != -1) {
            return storage[position].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return findFreeSpace();
    }

    private int findExistingPositionByKey(K key) {
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] == null) {
                return -1;
            }
            K storageKey = storage[i].getKey();
            if (storageKey == null && key == null
                    || storageKey != null && storageKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private int findFreeSpace() {
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
