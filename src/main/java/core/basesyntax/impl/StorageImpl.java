package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENT_NUMBER];
        values = new Object[MAX_ELEMENT_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENT_NUMBER; i++) {
            if (keysEquals(getKey(i), key)) {
                setValue(i, value);
                break;
            }
            if (getKey(i) == null && getValue(i) == null) {
                setKey(i, key);
                setValue(i, value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENT_NUMBER; i++) {
            if (keysEquals(getKey(i), key)) {
                return getValue(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_ELEMENT_NUMBER; i++) {
            if (getKey(i) == null && getValue(i) == null) {
                return i;
            }
        }
        return MAX_ELEMENT_NUMBER;
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
}
