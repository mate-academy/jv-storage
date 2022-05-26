package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_ELEMENTS= 10;
    private final K[] keyValues;
    private final V[] storedInfo;
    private int elements = 0;

    public StorageImpl() {
        keyValues = (K[]) new Object[MAX_ELEMENTS];
        storedInfo = (V[]) new Object[MAX_ELEMENTS];
    }

    private boolean obEqual(Object o1, Object o2) {
        return o1 == o2 || o1 != null && o1.equals(o2);
    }

    @Override
    public void put(K key, V value) {
        elements++;
        boolean newObject = true;
        for (int i = 0; i < elements - 1; i++) {
            if (obEqual(key, keyValues[i])) {
                storedInfo[i] = value;
                newObject = false;
                elements--;
                break;
            }
        }
        if (newObject) {
            keyValues[elements - 1] = key;
            storedInfo[elements - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elements; i++) {
            if (obEqual(key, keyValues[i])) {
                return storedInfo[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elements;
    }
}
