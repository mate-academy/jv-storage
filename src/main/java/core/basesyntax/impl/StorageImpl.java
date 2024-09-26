package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_LENGTH = 10;
    private K[] keysStorage;
    private V[] valuesStorage;
    private int length;

    public StorageImpl() {
        keysStorage = (K[]) new Object[ARRAY_MAX_LENGTH];
        valuesStorage = (V[]) new Object[ARRAY_MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (compareKeys(keysStorage[i],key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        if (isStorageFull()) {
            throw new RuntimeException("Can't add key: " + key + ", and value: " + value + "."
                    + " Storage is full");
        }
        keysStorage[length] = key;
        valuesStorage[length] = value;
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if (compareKeys(keysStorage[i], key)) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    private boolean compareKeys(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }

    private boolean isStorageFull() {
        return length == ARRAY_MAX_LENGTH;
    }
}
