package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_SIZE = 10;
    public static final int NO_RESULT = -1;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> toSave = new Pair<>(key, value);
        int position = findExistingPositionByKey(key);
        if (position != NO_RESULT) {
            storage[position] = toSave;
        } else {
            if (size < STORAGE_SIZE) {
                storage[size++] = toSave;
            } else {
                throw new ArrayStoreException("Storage is out of free space!");
            }
        }
    }

    @Override
    public V get(K key) {
        int position = findExistingPositionByKey(key);
        if (position != NO_RESULT) {
            return storage[position].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findExistingPositionByKey(K key) {
        for (int i = 0; i < size; i++) {
            final K storageKey = storage[i].getKey();
            if (storageKey == null && key == null
                    || storageKey != null && storageKey.equals(key)) {
                return i;
            }
        }
        return NO_RESULT;
    }
}
