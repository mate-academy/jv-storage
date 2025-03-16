package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.exceptions.NotEnoughSpaceException;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int insertPosition = findValuePositionByKey(key);
        if (isFound(insertPosition)) {
            values[insertPosition] = value;
            return;
        }
        if (isStorageHaveSpace()) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        throw new NotEnoughSpaceException("There is no enough space in storage");
    }

    @Override
    public V get(K key) {
        int valuePosition = findValuePositionByKey(key);
        if (isFound(valuePosition)) {
            return values[valuePosition];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findValuePositionByKey(K keyToFind) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], keyToFind)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }

    private boolean isFound(int value) {
        return value != NOT_FOUND_INDEX;
    }

    private boolean isStorageHaveSpace() {
        return size != MAX_CAPACITY;
    }
}
