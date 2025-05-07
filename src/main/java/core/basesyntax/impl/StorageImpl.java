package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] keys = new Object[INITIAL_CAPACITY];
    private Object[] values = new Object[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (ifKeyIsValid(key,i)) {
                values[i] = value;
                return;
            }
        }

        ensureCapacity();
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (ifKeyIsValid(key,i)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == keys.length) {
            int newCapacity = keys.length * 2;
            keys = copyArray(keys, newCapacity);
            values = copyArray(values, newCapacity);
        }
    }

    private Object[] copyArray(Object[] array, int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    private boolean ifKeyIsValid(K key, int arrayIndex) {
        return ((keys[arrayIndex] == null && key == null)
               || (key != null && key.equals(keys[arrayIndex])));
    }
}
