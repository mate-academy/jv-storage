package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private int size;

    private int keyIndex;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        values = (V[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        size = -1;
    }

    @Override
    public void put(K key, V value) {
        keyIndex = findKey(key);
        if (keyIndex == -1) {
            size += 1;
            size = (values[size] == null) ? size : size + 1;
            keys[size] = key;
            values[size] = value;
        } else {
            values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        keyIndex = findKey(key);
        return (keyIndex == -1) ? null : values[keyIndex];
    }

    @Override
    public int size() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return size;
    }

    private int findKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
