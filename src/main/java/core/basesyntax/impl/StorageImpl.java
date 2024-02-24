package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null ? key == null : keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
        for (int j = 0; j < keyArray.length; j++) {
            if (keyArray[j] == null && valueArray[j] == null) {
                keyArray[j] = key;
                valueArray[j] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null ? key == null : keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (V element : valueArray) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }
}
