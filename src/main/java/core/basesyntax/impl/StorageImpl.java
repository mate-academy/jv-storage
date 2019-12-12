package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int STORAGE_SIZE = 10;

    private Object[] keyStorage;
    private Object[] valueStorage;
    private int positionCounter;

    public StorageImpl() {
        keyStorage = new Object[STORAGE_SIZE];
        valueStorage = new Object[STORAGE_SIZE];
        positionCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (key != null && key.equals(keyStorage[i]) || key == keyStorage[i]) {
                keyStorage[i] = key;
                valueStorage[i] = value;
            }
        }
        keyStorage[positionCounter] = key;
        valueStorage[positionCounter] = value;
        positionCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < positionCounter; i++) {
            if (key != null && key.equals(keyStorage[i]) || key == keyStorage[i]) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }
}
