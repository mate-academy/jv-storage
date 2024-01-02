package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            if (size + 1 > MAX_ITEMS_NUMBER) {
                throw new RuntimeException("Cannot add more elements!"
                        + " The size of storage is " + MAX_ITEMS_NUMBER);
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
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
