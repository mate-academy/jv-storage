package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[][] storageArray;

    public StorageImpl() {
        this.storageArray = new Object[MAX_SIZE][2];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storageArray[i][1] == null) {
                storageArray[i][0] = key;
                storageArray[i][1] = value;
                break;
            }
            if (key != null && storageArray[i][0] != null) {
                if (storageArray[i][0].equals(key)) {
                    storageArray[i][1] = value;
                    break;
                }
            }
            if (storageArray[i][0] == key) {
                storageArray[i][1] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (key != null && storageArray[i][0] != null) {
                if (storageArray[i][0].equals(key)) {
                    return (V) storageArray[i][1];
                }
            }
            if (storageArray[i][0] == key) {
                return (V) storageArray[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storageArray[i][1] == null) {
                return i;
            }
        }
        return MAX_SIZE;
    }
}
