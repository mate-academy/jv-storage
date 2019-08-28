package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private final int initialCapacity = 16;
    private Object[] keys;
    private Object[] values;
    private double loadFactory = 0.75;
    private int currentCapacity;


    public StorageImpl() {
        keys = new Object[initialCapacity];
        values = new Object[initialCapacity];
        currentCapacity = 0;
        keys[0] = null;
    }

    private void extCapacity() {
        if (currentCapacity >= loadFactory * initialCapacity) {
            values = Arrays.copyOf(values, values.length * 2);
            keys = Arrays.copyOf(keys, keys.length * 2);
        }
    }

    private int isKeyThere(K key) {
        if (key == null) {
            return 0;
        }
        for (int i = 1; i < currentCapacity; i++) {
            if (key.equals((K) keys[i])) {
                return i;
            }
        }
        return currentCapacity++;
    }

    @Override
    public void put(K key, V value) {
        extCapacity();
        if (value != null) {
            int num = isKeyThere(key);
            keys[num] = key;
            values[num] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentCapacity; i++) {
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

