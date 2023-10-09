package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int insertPosition = findValuePositionByKey(key);
        if (isFound(insertPosition)) {
            values[insertPosition] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
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
}
