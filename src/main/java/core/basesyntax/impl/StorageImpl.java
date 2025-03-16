package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int itemsSize;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        itemsSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (values[i] == null) {
                values[i] = value;
                keys[i] = key;
                itemsSize++;
                return;
            }
            if (isEqual(key, (K) keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemsSize; i++) {
            if (isEqual(key, (K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return itemsSize;
    }

    private boolean isEqual(K firstKey, K secondKey) {
        return firstKey == null && secondKey == null
                || secondKey != null && secondKey.equals(firstKey);
    }
}
