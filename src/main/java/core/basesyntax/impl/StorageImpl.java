package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private StorageArray[] storageArray;

    public StorageImpl() {
        this.storageArray = new StorageArray[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            storageArray[i] = new StorageArray<>(null,null);
        }
    }

    public boolean nullCheck(K key, int i) {
        if (key != null && storageArray[i].getKey() != null) {
            return (storageArray[i].getKey().equals(key));
        }
        return (storageArray[i].getKey() == key);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storageArray[i].getKey() == null && storageArray[i].getValue() == null) {
                storageArray[i].setKey(key);
                storageArray[i].setValue(value);
                break;
            }
            if (nullCheck(key,i)) {
                storageArray[i].setValue(value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (nullCheck(key,i)) {
                return (V) storageArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (storageArray[i].getKey() == null && storageArray[i].getValue() == null) {
                return i;
            }
        }
        return MAX_SIZE;
    }
}
