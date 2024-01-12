package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
        } else {
            int index = indexOf(key);
            if (index != -1) {
                values[index] = value;
            } else {
                ensureCapacity();
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }
        int index = indexOf(key);
        return (index != -1) ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size == keys.length) {
            resizeArrays();
        }
    }

    private void resizeArrays() {
        int newCapacity = keys.length * 2;
        keys = (K[]) resizeArray(keys, newCapacity);
        values = (V[]) resizeArray(values, newCapacity);
    }

    private Object[] resizeArray(Object[] array, int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    private void putNullKey(V value) {
        int nullKeyIndex = indexOfNullKey();
        if (nullKeyIndex != -1) {
            values[nullKeyIndex] = value;
        } else {
            ensureCapacity();
            keys[size] = null;
            values[size] = value;
            size++;
        }
    }

    private V getNullKey() {
        int nullKeyIndex = indexOfNullKey();
        return (nullKeyIndex != -1) ? values[nullKeyIndex] : null;
    }

    private int indexOfNullKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
