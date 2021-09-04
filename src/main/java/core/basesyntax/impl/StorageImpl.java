package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int sizeOfArray;

    public StorageImpl() {
        keysArray = (K[])(new Object[MAX_ITEMS_NUMBER]);
        valuesArray = (V[])(new Object[MAX_ITEMS_NUMBER]);
        sizeOfArray = 0;
    }

    @Override
    public void put(K key, V value) {
        if (sizeOfArray >= MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Storage capacity exeeded");
        }
        for (int i = 0; i < sizeOfArray; i++) {
            if (equal(key, keysArray[i])) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[sizeOfArray] = key;
        valuesArray[sizeOfArray] = value;
        sizeOfArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (equal(key, keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

    public boolean equal(K key, K keyFromArray) {
        return key == keyFromArray || (key != null && key.equals(keyFromArray));
    }
}
