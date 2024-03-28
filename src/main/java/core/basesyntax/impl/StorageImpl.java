package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.exeptions.StorageException;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_STORAGE_LENGTH = 10;
    private int lastItemIndex = 0;
    private final Pair<K, V>[] storage;

    public StorageImpl() {
        this.storage = new Pair[MAXIMUM_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (Pair pair : storage) {
            if (pair == null) {
                continue;
            }
            Object pairKey = pair.getKey();
            if (Objects.equals(pairKey, key)) {
                pair.setValue(value);
                return;
            }
        }
        if (storage.length > MAXIMUM_STORAGE_LENGTH) {
            throw new StorageException("Storage is out of capacity");
        }
        storage[lastItemIndex] = new Pair<>(key, value);
        lastItemIndex++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storage) {
            if (pair == null) {
                continue;
            }
            K pairKey = pair.getKey();
            if (Objects.equals(pairKey, key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastItemIndex;
    }
}
