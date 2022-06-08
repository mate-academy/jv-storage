package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.security.Key;

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

    public Integer searchedKey(K key) {
        boolean condition;
        Integer result = null;
            for (int index = 0; index < size; index++) {
                if ((arrayKeys.getElement(index) == null || key == null)
                    && arrayKeys.getElement(index) == key ) {
                    result = index;
                } else if (arrayKeys.getElement(index).equals(key)) {
                    result = index;
                }
            }
        return result;
    }

    @Override
    public void put(K key, V value) {
        Integer searchedIndex = searchedKey(key);
        if (searchedIndex != null) {
            arrayValues.setElement(searchedIndex, value);
        } else if (size < MAX_LENGTH) {
            arrayKeys.setElement(size, key);
            arrayValues.setElement(size, value);
            size++;
            }
    }

    @Override
    public V get(K key) {
        Integer searchedIndex = searchedKey(key);
        if (searchedIndex != null) {
            V result = arrayValues.getElement(searchedIndex);
            return result;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
