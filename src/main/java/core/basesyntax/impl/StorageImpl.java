package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[DEFAULT_CAPACITY];
        this.values = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
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

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return (index != -1) ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
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
        keys = resizeArray(keys, newCapacity);
        values = resizeArray(values, newCapacity);
    }

    private Object[] resizeArray(Object[] array, int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    private boolean areKeysEqual(K key1, Object key2) {
        if (key1 == null) {
            return key2 == null;
        }
        return key1.equals(key2);
    }
}
