package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_LENGTH = 10;
    private int generalKey = 0;
    private K[] keys = (K[]) new Object[ARRAY_LENGTH];
    private V[] values = (V[]) new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        if (isKeyExists(key)) {
            values[getCellNumber(key)] = value;
        } else {
            keys[generalKey] = key;
            values[generalKey] = value;
            generalKey++;
        }
    }

    @Override
    public V get(K key) {
        int cellNumber = getCellNumber(key);
        if (cellNumber == -1) {
            return null;
        }
        return values[cellNumber];
    }

    private boolean isKeyExists(K key) {
        for (int i = 0; i < generalKey; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int getCellNumber(K key) {
        for (int i = 0; i < generalKey; i++) {
            if ((keys[i] == null && key == null) || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
