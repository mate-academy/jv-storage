package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Object[] keyStorage;
    private Object[] valueStorage;
    private int index;

    public StorageImpl() {
        index = 0;
        keyStorage = new Object[LENGTH];
        valueStorage = new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (find(key) >= 0) {
            valueStorage[find(key)] = value;
        } else {
            keyStorage[index] = key;
            valueStorage[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (keyStorage[i] == key || (key != null && key.equals(keyStorage[i]))) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    private int find(K key) {
        for (int i = 0; i < index; i++) {
            if (keyStorage[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
