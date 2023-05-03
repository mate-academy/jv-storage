package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keysAndValues;
    private final int maxSize;
    private final int pairNum = 2;
    private int size;

    public StorageImpl() {
        keysAndValues = new Object[20];
        maxSize = 10;
    }

    private boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keysAndValues[i] == null
                    || key != null && key.equals(keysAndValues[i])) {
                return true;
            }
        }
        return false;
    }

    private void updateValue(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keysAndValues[i] == null
                    || key != null && key.equals(keysAndValues[i])) {
                keysAndValues[i + 1] = value;
                return;
            }
        }
    }

    private V getValue(int index) {
        return (V) keysAndValues[index + 1];
    }

    private void addKeyValuePair(K key, V value) {
        if (size == keysAndValues.length) {
            keysAndValues = Arrays.copyOf(keysAndValues, size * pairNum);
        }
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
            if (key == null && keysAndValues[i] == null
                    || key != null && key.equals(keysAndValues[i])) {
                return getValue(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        // return number of elements divided by two
        return size / pairNum;
    }
}
