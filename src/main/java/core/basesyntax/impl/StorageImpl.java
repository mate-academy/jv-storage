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
