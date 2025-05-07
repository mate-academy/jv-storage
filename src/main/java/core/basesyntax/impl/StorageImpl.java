package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_ELEMENTS = 10;
    private final Object[] keyValues;
    private final Object[] storedInfo;
    private int elements;

    public StorageImpl() {
        keyValues = new Object[MAX_ELEMENTS];
        storedInfo = new Object[MAX_ELEMENTS];
        elements = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keyValues[elements] = key;
            storedInfo[elements] = value;
            elements++;
        } else {
            storedInfo[elements - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elements; i++) {
            if (obEqual(key, keyValues[i])) {
                return (V) storedInfo[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elements;
    }

    private boolean obEqual(Object o1, Object o2) {
        return o1 == o2 || o1 != null && o1.equals(o2);
    }
}
