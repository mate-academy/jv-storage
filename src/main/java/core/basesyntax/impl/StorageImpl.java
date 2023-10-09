package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
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
        if (insertPosition != -1) {
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
        if (valuePosition != -1) {
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
            if (isKeysEqual(keys[i], keyToFind)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isKeysEqual(K firstKey, K secondKey) {
        return (firstKey == secondKey) || (firstKey != null && firstKey.equals(secondKey));
    }
}
