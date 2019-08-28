package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private final int maxSize = 16;
    private Object[] keys;
    private Object[] values;
    private double loadFactory = 0.75;
    private int curCapacity;

    public StorageImpl() {
        keys = new Object[maxSize];
        values = new Object[maxSize];
        curCapacity = 1;
        keys[0] = null;
    }

    private void extCapacity() {
        if (curCapacity >= loadFactory * maxSize) {
            values = Arrays.copyOf(values, values.length * 2);
            keys = Arrays.copyOf(keys, keys.length * 2);
        }
    }

    private int isKeyThere(K key) {
        if (key == null) {
            return 0;
        }
        for (int i = 1; i < curCapacity; i++) {
            if (key.equals((K) keys[i])) {
                return i;
            }
        }
        extCapacity();
        return curCapacity++;
    }

    @Override
    public void put(K key, V value) {
        int num;
        if (value != null) {
            num = isKeyThere(key);
            keys[num] = key;
            values[num] = value;
        }
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