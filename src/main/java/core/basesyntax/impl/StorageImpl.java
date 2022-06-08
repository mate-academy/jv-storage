package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K key;
    private V value;
    //private GenericArray<K> arrayKeys = new GenericArray(MAX_LENGTH);
    //private GenericArray<V> arrayValues = new GenericArray(MAX_LENGTH);
    private K[] keys = (K[]) new Object[MAX_LENGTH];
    private V[] values = (V[]) new Object[MAX_LENGTH];

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    //private class GenericArray<T> {
        //private Object[] arrayT;

        //public GenericArray(int size) {
            //arrayT = new Object[size];
        //}

        //public T getElement(int index) {
            //return (T) arrayT[index];
        //}

        //public void setElement(int index, T element) {
            //arrayT[index] = element;
        //}
    //}

    public Integer searchedKey(K key) {
        Integer result = null;
        for (int index = 0; index < size; index++) {
            if ((keys[index] == null || key == null)
                    && keys[index] == key) {
                result = index;
            } else if (keys[index].equals(key)) {
                result = index;
            }
        }
        return result;
    }

    @Override
    public void put(K key, V value) {
        Integer searchedIndex = searchedKey(key);
        if (searchedIndex != null) {
            values[searchedIndex] = value;
        } else if (size < MAX_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Integer searchedIndex = searchedKey(key);
        if (searchedIndex != null) {
            return (V) values[searchedIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
