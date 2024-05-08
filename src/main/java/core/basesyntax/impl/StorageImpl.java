package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int indexForNexElem = 0;
    private int size;
    private K[] keyStorage;
    private V[] valueStorage;

    public StorageImpl() {
        size = 0;
        keyStorage = (K[]) new Object[MAX_SIZE];
        valueStorage = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {

        if (containsKey(key)) {
            valueStorage[getKeyIndex(key)] = value;
        } else {
            if (size == MAX_SIZE) {
                throw new RuntimeException("The storage is full");
            }
            keyStorage[indexForNexElem] = key;
            valueStorage[indexForNexElem] = value;
            indexForNexElem++;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return valueStorage[getKeyIndex(key)];
        }
        if (!containsKey(key)) {
            return null;
        }
        return valueStorage[getKeyIndex(key)];
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keyStorage[i] == null
                    : keyStorage[i] != null && keyStorage[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keyStorage[i] == null
                    : keyStorage[i] != null && keyStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void putWithNullKey(K key, V value) {
        if (value == null) {
            keyStorage[indexForNexElem] = null;
            valueStorage[indexForNexElem] = null;
            indexForNexElem++;
            size++;
        } else {
            keyStorage[indexForNexElem] = null;
            valueStorage[indexForNexElem] = value;
            indexForNexElem++;
            size++;
        }
    }
}
