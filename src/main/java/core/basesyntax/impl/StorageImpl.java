package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int keyCells = 0;
    private static final int valueCells = 1;
    private static final int GENERICS_TYPE_COUNT = 2;
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size;
    private final Object[][] storage;

    public StorageImpl() {
        storage = new Object[GENERICS_TYPE_COUNT][MAX_ELEMENTS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        if (checkArrayForExistKey(key, value)) {
            return;
        }
        storage[keyCells][size] = key;
        storage[valueCells][size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(storage[keyCells][i]))
                    || (storage[keyCells][i] == key)) {
                @SuppressWarnings("unchecked") V value = (V) storage[valueCells][i];
                return value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkArrayForExistKey(K key, V value) {
        for (int index = 0; index < size; index++) {
            if ((key != null && key.equals(storage[keyCells][index]))
                    || (storage[keyCells][index] == key)) {
                replaceValue(value, index);
                return true;
            }
        }
        return false;
    }

    private void replaceValue(V value, int index) {
        storage[valueCells][index] = value;
    }
}
