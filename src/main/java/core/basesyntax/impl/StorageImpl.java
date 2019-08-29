package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private static final int MAX_SIZE = 16;
    private Object[] keys;
    private Object[] values;
    private static final double LOAD_FACTORY = 0.75;
    private int curCapacity;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        curCapacity = 1;
        keys[0] = null;
    }

    private void increaseCapacity() {
        if (curCapacity >= LOAD_FACTORY * MAX_SIZE) {
            values = Arrays.copyOf(values, values.length + values.length >> 1);
            keys = Arrays.copyOf(keys, keys.length + keys.length >> 1);
        }
    }

    private int indexOfElement(K key) {
        if (key == null) {
            return 0;
        }
        for (int i = 1; i < curCapacity; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        increaseCapacity();
        return curCapacity++;
    }

    @Override
    public void put(K key, V value) {
        int num = indexOfElement(key);
        keys[num] = key;
        values[num] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < curCapacity; i++) {
            if (key == null) {
                return (V) values[0];
            }
            if (key.equals((K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }
}