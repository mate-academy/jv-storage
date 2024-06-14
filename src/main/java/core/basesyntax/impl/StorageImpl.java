package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        boolean isReplaced = false;
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
            isReplaced = true;
        }
        if (!isReplaced) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        V foundValueByKey = null;
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return foundValueByKey;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                index = i;
            }
        }
        return index;
    }
}
