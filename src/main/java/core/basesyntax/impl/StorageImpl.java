package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;

    private Object[] arrayKey = new Object[ARRAY_MAX_SIZE];
    private Object[] arrayValue = new Object[ARRAY_MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == null && arrayKey[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                return;
            } else if (key != null && key.equals(arrayKey[i])) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                return;
            } else if (arrayKey[i] == null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == null && arrayKey[i] == null) {
                return (V) arrayValue[i];
            } else if (key != null && key.equals(arrayKey[i])) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < arrayKey.length; i++) {
            if (arrayKey[i] != null || arrayValue[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
