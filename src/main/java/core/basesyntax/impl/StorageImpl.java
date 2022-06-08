package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K key;
    private V value;
    private GenericArray<K> arrayKeys = new GenericArray(MAX_LENGTH);
    private GenericArray<V> arrayValues = new GenericArray(MAX_LENGTH);

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    private class GenericArray<T> {
        private Object[] arrayT;

        public GenericArray(int size) {
            arrayT = new Object[size];
        }

        public T getElement(int index) {
            return (T) arrayT[index];
        }

        public void setElement(int index, T element) {
            arrayT[index] = element;
        }
    }

    public boolean testArray(GenericArray<V> arrayV) {
        boolean result = false;
        for (int index = 0; index < MAX_LENGTH; index++) {
            if (arrayV.getElement(index) != null) {
                result = true;
            }
        }
        return result;
    }

    public boolean[] searchedKey(K key) {
        boolean[] comparisonTable = new boolean[MAX_LENGTH];
        boolean condition;
        if (testArray(arrayValues)) {
            for (int index = 0; index < size; index++) {
                if (arrayKeys.getElement(index) == null || key == null) {
                    condition = arrayKeys.getElement(index) == key;
                } else {
                    condition = arrayKeys.getElement(index).equals(key);
                }
                comparisonTable[index] = condition;
            }
        }
        return comparisonTable;
    }

    @Override
    public void put(K key, V value) {
        int currentIndex;
        boolean checkPresent = false;
        if (!testArray(arrayValues)) {
            currentIndex = 0;
            size = 0;
            arrayKeys.setElement(currentIndex, key);
            arrayValues.setElement(currentIndex, value);
            size++;
        } else {
            boolean[] comparisonTable = searchedKey(key);
            for (currentIndex = 0; currentIndex < size; currentIndex++) {
                if (comparisonTable[currentIndex]) {
                    arrayValues.setElement(currentIndex, value);
                    checkPresent = true;
                }
            }
            if (!checkPresent && (size < MAX_LENGTH)) {
                arrayKeys.setElement(currentIndex, key);
                arrayValues.setElement(currentIndex, value);
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (testArray(arrayValues)) {
            boolean[] comparisonTable = searchedKey(key);
            int index;
            for (index = 0; index < size; index++) {
                if (comparisonTable[index]) {
                    V result = arrayValues.getElement(index);
                    return result;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
