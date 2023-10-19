package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int currentCapacity;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
        currentCapacity = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentCapacity; i++) {
            if (key == null && keys[i] == null) {
                values[i] = value;
                return;
            } else if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        addNewValue(key, value);
    }

    private void addNewValue(K key, V value) {
        if (currentCapacity < INITIAL_CAPACITY) {
            keys[currentCapacity] = key;
            values[currentCapacity] = value;
            currentCapacity++;
        }
    }

    @Override
    public V get(K key) {
        if (Arrays.asList(keys).contains(key)) {
            int index = Arrays.asList(keys).indexOf(key);
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return currentCapacity;
    }
}
