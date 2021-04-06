package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int FIRST_INDEX_OF_ARRAY = 0;
    private int indexOfEmptyElement;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        indexOfEmptyElement = FIRST_INDEX_OF_ARRAY;
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (indexOfEmptyElement == keys.length) {
            throw new RuntimeException("You cannot put the data. The storage is full.");
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                break;
            }
            if (equalsKeys(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[indexOfEmptyElement] = key;
        values[indexOfEmptyElement] = value;
        indexOfEmptyElement++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (equalsKeys(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexOfEmptyElement;
    }

    private boolean equalsKeys(Object newKey, K keyInStorage) {
        if (newKey == keyInStorage || newKey != null && newKey.equals(keyInStorage)) {
            return true;
        }
        return false;
    }
}
