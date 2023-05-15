package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int PAIR_NUM = 2;
    private Object[] keysAndValues;
    private int size;

    public StorageImpl() {
        keysAndValues = new Object[MAX_SIZE * PAIR_NUM];
    }

    private boolean keysAreEqual(K key, Object storedKey) {
        return key == null && storedKey == null
                || key != null && key.equals(storedKey);
    }

    private boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(key, keysAndValues[i])) {
                return true;
            }
        }
        return false;
    }

    private void updateValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(key, keysAndValues[i])) {
                keysAndValues[i + 1] = value;
                return;
            }
        }
    }

    private V getValue(int index) {
        return (V) keysAndValues[index + 1];
    }

    private void addKeyValuePair(K key, V value) {
        keysAndValues[size++] = key;
        keysAndValues[size++] = value;
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            updateValue(key, value);
        } else {
            addKeyValuePair(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(key, keysAndValues[i])) {
                return getValue(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size / PAIR_NUM;
    }
}
