package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] arrayWithKeys;
    private V[] arrayWithValue;
    private int size;

    public StorageImpl() {
        arrayWithKeys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        arrayWithValue = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEquals(arrayWithKeys[i], key)) {
                arrayWithValue[i] = value;
                return;
            }
        }
        arrayWithKeys[size] = key;
        arrayWithValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEquals(arrayWithKeys[i], key)) {
                return arrayWithValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEquals(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }
}
