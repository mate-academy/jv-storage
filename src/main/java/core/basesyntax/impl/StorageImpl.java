package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE_NUMBER = 0;
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        size = INITIAL_SIZE_NUMBER;
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (isKeyExist(key)) {
            int insertPosition = findValuePositionByKey(key);
            values[insertPosition] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (!isKeyExist(key)) {
            return null;
        }
        V valueToFind = values[findValuePositionByKey(key)];
        return valueToFind;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyExist(K keyToFind) {
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(keys[i], keyToFind)) {
                return true;
            }
        }
        return false;
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
