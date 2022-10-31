package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final byte MAX_ITEMS_NUMBER = 10;
    private final K[] arrayKeys;
    private final V[] arrayValues;
    private byte index = 0;
    private boolean nullMarker = false;

    public StorageImpl() {
        arrayValues = (V[]) new Object[MAX_ITEMS_NUMBER];
        arrayKeys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (index == MAX_ITEMS_NUMBER) {
            index = 0;
        }
        for (int i = 0; i < arrayKeys.length; i++) {
            if (arrayKeys[i] != null && arrayKeys[i].equals(key)) {
                arrayValues[i] = value;
                index--;
            }
        }
        if (key == null) {
            if (nullMarker) {
                index--;
            }
            arrayKeys[index] = null;
            arrayValues[index] = value;
            index++;
            nullMarker = true;
        }
        if (key != null) {
            arrayKeys[index] = key;
            arrayValues[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (key == null && arrayKeys[i] == null) {
                return arrayValues[i];
            }
            if (arrayKeys[i] != null && arrayKeys[i].equals(key)) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
