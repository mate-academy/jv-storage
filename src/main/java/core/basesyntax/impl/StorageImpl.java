package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K key;
    private V value;
    private int size;
    private Object[] keyStorage;
    private Object[] valueStorage;

    public StorageImpl() {
        keyStorage = new Object[MAX_ITEMS_NUMBER];
        valueStorage = new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keyStorage[i] != null && keyStorage[i].equals(key)) || keyStorage[i] == key) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[size] = key;
        valueStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keyStorage[i] != null && keyStorage[i].equals(key)) || keyStorage[i] == key) {
                return (V)valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
