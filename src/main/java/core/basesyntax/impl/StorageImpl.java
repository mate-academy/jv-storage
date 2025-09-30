package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int MIN_CAPACITY = 0;
    private static final String ISE_MESSAGE = "Storage is full, can't add new item";
    private K[] keyList;
    private V[] valueList;
    private int numberOfItemsInList;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keyList = (K[]) new Object[MAX_CAPACITY];
        this.valueList = (V[]) new Object[MAX_CAPACITY];
        numberOfItemsInList = MIN_CAPACITY;
    }

    @Override
    public void put(K key, V value) {
        int indexOfElement = indexOfKey(key);
        if (indexOfElement == -1) {
            if (numberOfItemsInList < MAX_CAPACITY) {
                keyList[numberOfItemsInList] = key;
                valueList[numberOfItemsInList] = value;
                numberOfItemsInList++;
            } else {
                throw new IllegalStateException(ISE_MESSAGE);
            }
        } else {
            valueList[indexOfElement] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexOfElement = indexOfKey(key);
        return indexOfElement == -1 ? null : valueList[indexOfElement];
    }

    @Override
    public int size() {
        return numberOfItemsInList;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < numberOfItemsInList; i++) {
            if (key == null && keyList[i] == null) {
                return i;
            }
            if (key != null && key.equals(keyList[i])) {
                return i;
            }
        }
        return -1;
    }
}
