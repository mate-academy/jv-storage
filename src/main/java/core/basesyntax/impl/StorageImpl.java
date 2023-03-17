package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private int sizeInt = 0;
    private Object[] keyArray = new Object[MAX_ARRAY_LENGTH];
    private Object[] valueArray = new Object[MAX_ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        boolean createNewIndexStorage = true;

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (key != null && keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                createNewIndexStorage = false;
                break;
            }
            if (key == null && keyArray[i] == null && valueArray[i] != null) {
                valueArray[i] = value;
                createNewIndexStorage = false;
                break;
            }
        }
        if (createNewIndexStorage) {
            for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
                if (keyArray[i] == null && valueArray[i] == null) {
                    keyArray[i] = key;
                    valueArray[i] = value;
                    sizeInt++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (key != null && keyArray[i] != null && keyArray[i].equals(key)) {
                return (V) valueArray[i];
            }
            if (key == null && keyArray[i] == null) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeInt;
    }

}


