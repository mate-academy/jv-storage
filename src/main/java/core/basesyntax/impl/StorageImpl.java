package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final Object[] arrayK;
    private final Object[] arrayV;
    private int arrayIndex;

    public StorageImpl() {
        arrayK = new Object[MAX_ELEMENTS];
        arrayV = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            arrayK[arrayIndex] = null;
        }
        if (arrayIndex > 0 && (key == arrayK[arrayIndex - 1]
                || key != null && key.equals(arrayK[arrayIndex - 1]))) {
            arrayK[arrayIndex - 1] = key;
            arrayV[arrayIndex - 1] = value;
        } else {
            arrayK[arrayIndex] = key;
            arrayV[arrayIndex] = value;
            arrayIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayK.length; i++) {
            if (key == arrayK[i] || key != null && key.equals(arrayK[i])) {
                return (V) arrayV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayIndex;
    }
}
