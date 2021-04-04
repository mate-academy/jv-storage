package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int indexOfEmptyElement;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        indexOfEmptyElement = 0;
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (indexOfEmptyElement == keys.length) {
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                break;
            } else if (equalsKeys(key, keys[i])) {
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
        if (newKey == keyInStorage) {
            return true;
        }
        if (newKey == null || keyInStorage == null) {
            return false;
        }
        if (newKey.getClass().equals(keyInStorage.getClass())) {
            K current = (K) newKey;
            return current.equals(keyInStorage);
        }
        return false;
    }
}
