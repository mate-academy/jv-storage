package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keys;
    private V[] values;
    private int size;
    private int capacity = 10;
    private int index = 0;
    private boolean nullKeyExists = false;

    public StorageImpl() {
        this.size = 0;
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    public boolean containsKey(K addingKey) {
        for (K key : keys) {
            if (Objects.equals(key, addingKey)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(K addingValue) {
        for (V value : values) {
            if (Objects.equals(value, addingValue)) {
                return true;
            }
        }
        return false;
    }

    private <T> T[] resizeArray(T[] array) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    public int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return size;
    }

    public int indexOfValue(V value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    public void delete(K key) {
        if (key == null && !nullKeyExists) {
            return;
        }
        int index = indexOfKey(key);
        if (index != -1) {
            System.arraycopy(keys, index + 1, keys, index, size - index - 1);
            System.arraycopy(values, index + 1, values, index, size - index - 1);
            if (key == null) {
                nullKeyExists = false;
            }
            size--;
        }
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            index = indexOfKey(key);
            values[index] = value;
            if (key == null && nullKeyExists == false) {
                size++;
                nullKeyExists = true;
            }
        } else {
            if (size == capacity) {
                capacity = capacity * 2;
                keys = resizeArray(keys);
                values = resizeArray(values);
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            index = indexOfKey(key);
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
