package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_LENGTH = 10;

    private K [] keyArray;
    private V [] valueArray;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[STORAGE_LENGTH];
        this.valueArray = (V[]) new Object[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_LENGTH; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                keyArray [i] = key;
                valueArray[i] = value;
                break;
            }
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_LENGTH; i++) {
            if ((keyArray[i] == null && key == null) || (key != null && key.equals(keyArray[i]))) {
                return valueArray[i];
            }
        }
        return null;
    }
}
