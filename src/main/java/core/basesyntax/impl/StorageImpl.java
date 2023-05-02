package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ARRAY_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_NUMBER_OF_ARRAY_LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
            if (isKeyEquals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (isKeyEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean isKeyEquals(K firstKey, K secondKey) {
        return firstKey == secondKey || (firstKey != null) && firstKey.equals(secondKey);
    }

    @Override
    public int size() {
        return size;
    }
}
