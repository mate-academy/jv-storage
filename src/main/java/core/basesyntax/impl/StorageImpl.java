package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[]{};
        values = (V[]) new Object[]{};
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            if (keys.length + 1 > MAX_ITEMS_NUMBER) {
                throw new RuntimeException("Cannot add more elements!"
                        + " The size of storage is " + MAX_ITEMS_NUMBER);
            }
            keys = Arrays.copyOf(keys, keys.length + 1);
            values = Arrays.copyOf(values, values.length + 1);
            int size = keys.length;
            keys[size - 1] = key;
            values[size - 1] = value;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (compareKeys(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.length;
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (compareKeys(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean compareKeys(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
}
