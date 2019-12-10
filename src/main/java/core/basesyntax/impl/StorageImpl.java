package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private static Object[] arrayKeys = new Object[CAPACITY];
    private static Object[] arrayValues = new Object[CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (key == null && arrayKeys[i] == null) {
                arrayKeys[i] = key;
                arrayValues[i] = value;
                return;
            } else if (key != null && key.equals(arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            } else if (key != null && arrayKeys[i] == null && arrayValues[i] == null) {
                arrayKeys[i] = key;
                arrayValues[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (key == null && arrayKeys[i] == null) {
                return (V)arrayValues[i];
            } else if (key != null && key.equals(arrayKeys[i])) {
                return (V)arrayValues[i];
            }
        }
        return null;
    }
}
