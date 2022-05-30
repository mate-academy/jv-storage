package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENT_NUMBER];
        values = new Object[MAX_ELEMENT_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            setKey(size, key);
            setValue(size, value);
            size++;
        } else {
            setValue(index, value);
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : getValue(index);
    }

    @Override
    public int size() {
        return size;
    }

    private K getKey(int index) {
        return (K) keys[index];
    }

    private V getValue(int index) {
        return (V) values[index];
    }

    private void setKey(int index, Object key) {
        this.keys[index] = key;
    }

    private void setValue(int index, Object value) {
        this.values[index] = value;
    }

    private boolean keysEquals(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    private int indexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if (keysEquals(getKey(i), key)) {
                return i;
            }
        }
        return -1;
    }
}
