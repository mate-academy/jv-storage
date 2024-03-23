package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] arrayOfKeys = new Object[10];
    private Object[] arrayOfValues = new Object[10];
    private int index = 0;
    private int storageSize = 0;
    private K key;

    @Override
    public void put(K key, V value) {
        boolean isDuplicated = false;
        if (this.key == null && key == null) {
            storageSize++;
        }
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (arrayOfKeys[i] == null && key == null) {
                arrayOfValues[i] = value;
                isDuplicated = true;
            }
            if (key != null && key.equals(arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                isDuplicated = true;
            }
        }
        if (isDuplicated == false) {
            arrayOfKeys[index] = key;
            arrayOfValues[index] = value;
            index++;
            storageSize++;
        }
        this.key = key;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            key = (K) "null";
        }
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (arrayOfKeys[i] == null) {
                arrayOfKeys[i] = "null";
            }
            if (arrayOfKeys[i].equals(key)) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
