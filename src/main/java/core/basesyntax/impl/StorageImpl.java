package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int NOT_FOUND_INDEX = -1;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int indexOfExistingValue = returnIndexOfExistingValue(key, value);
        if (size < MAX_CAPACITY) {
            if (indexOfExistingValue == NOT_FOUND_INDEX) {
                addToArrays(key, value, size);
                size++;
            } else {
                addToArrays(key, value, indexOfExistingValue);
            }
        } else {
            throw new RuntimeException("You can't add data because storage is full!");
        }
    }

    private void addToArrays(K key, V value, int index) {
        this.keys[index] = key;
        this.values[index] = value;
    }

    private int returnIndexOfExistingValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
