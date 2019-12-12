package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int indexCounter = 0;
    private static final int DEFAULT_ARRAY_LENGTH = 10;
    private Object[] keyArray = new Object[DEFAULT_ARRAY_LENGTH];
    private Object[] valueArray = new Object[DEFAULT_ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < indexCounter; i++) {
            if (key == null || key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[indexCounter] = key;
        valueArray[indexCounter] = value;
        indexCounter++;
    }

    @Override
    public V get(K key) {
        //
        for (int i = 0; i < keyArray.length; i++) {
            if (key == null || key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }
}

