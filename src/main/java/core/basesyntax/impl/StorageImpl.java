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
        size = 0;
    }

    @Override
    public void put(final K key, final V value) {
        // Search for the key in the array and update its value
        for (int i = 0; i < size; i += 2) {
            if (key == null && keysAndValues[i] == null) {
                keysAndValues[i + 1] = value;
                return;
            } else if (key != null && key.equals(keysAndValues[i])) {
                keysAndValues[i + 1] = value;
                return;
            }
        }
        // If the key does not exist in the array, add it and its value
        if (size == keysAndValues.length) {
            keysAndValues = Arrays.copyOf(keysAndValues, size * pairNum);
        }
        keysAndValues[size++] = key;
        keysAndValues[size++] = value;
    }

    @Override
    public V get(final K key) {
        // Find the key and return its value
        for (int i = 0; i < size; i += 2) {
            if (key == null && keysAndValues[i] == null) {
                return (V) keysAndValues[i + 1];
            } else if (key != null && key.equals(keysAndValues[i])) {
                return (V) keysAndValues[i + 1];
            }
        }
        // return null if key doesn't exist
        return null;
    }

    @Override
    public int size() {
        // return number of elements divided by two
        return size / pairNum;
    }
}
