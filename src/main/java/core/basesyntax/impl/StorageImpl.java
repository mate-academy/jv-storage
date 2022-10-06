package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private static int count;
    private final Object[] keyStorage;
    private final Object[] valueStorage;

    public StorageImpl() {
        keyStorage = new Object[SIZE];
        valueStorage = new Object[SIZE];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (count == 10) {
            throw new RuntimeException("Can't add new object to storage, because storage is full!");
        }
        for (int i = 0; i < keyStorage.length; i++) {
            if ((key != null && key.equals(keyStorage[i]))
                    || (count != 0 && key == keyStorage[i]) && valueStorage[i] != null) {
                valueStorage[i] = value;
                break;
            } else if (i == keyStorage.length - 1) {
                keyStorage[count] = key;
                valueStorage[count] = value;
                count++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
