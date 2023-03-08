package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_INDEX = 0;
    private K key;
    private V value;
    private StorageImpl<K, V>[] arrayElements;
    private int size;

    public StorageImpl() {
        arrayElements = new StorageImpl[10];
        size = 0;
    }

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private K getKey() {
        return key;
    }

    private V getValue() {
        return value;
    }

    private void setValue(V value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            arrayElements[INITIAL_INDEX] = new StorageImpl<>(key, value);
            size++;
        } else {
            int index = findIndex(key);
            if (index != -1) {
                arrayElements[index].setValue(value);
            } else {
                arrayElements[size] = new StorageImpl<>(key, value);
                size++;
            }
        }
    }

    private int findIndex(K element) {
        for (int i = 0; i < size; i++) {
            try {
                if (arrayElements[i].getKey().equals(element)) {
                    return i;
                }
            } catch (NullPointerException e) {
                if (arrayElements[i].getKey() == null && element == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return arrayElements[index].getValue();
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
