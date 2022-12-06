package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private Object[] keys = new Object[MAX_ELEMENTS_NUMBER];
    private Object[] values = new Object[MAX_ELEMENTS_NUMBER];
    private int elementsCount = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < elementsCount; i++) {
            if (isEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[elementsCount] = key;
        values[elementsCount] = value;
        elementsCount++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsCount; i++) {
            if (isEqual(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    private boolean isEqual(Object key1, Object key2) {
        return key1 == null && key2 == null || key1 != null && key1.equals(key2);
    }

}
