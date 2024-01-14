package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = indexOf(key);
        if (indexOfKey < 0) {
            if (size == keys.length) {
                extendCapacity();
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[indexOfKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexOfKey = indexOf(key);
        return indexOfKey < 0 ? null : values[indexOfKey];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void extendCapacity() {
        int newCapacity = keys.length + keys.length / 2;
        K[] keysWithNewCapacity = (K[]) new Object[newCapacity];
        V[] valuesWithNewCapacity = (V[]) new Object[newCapacity];
        for (int i = 0; i < keys.length; i++) {
            keysWithNewCapacity[i] = keys[i];
            valuesWithNewCapacity[i] = values[i];
        }
        keys = keysWithNewCapacity;
        values = valuesWithNewCapacity;
    }
}
