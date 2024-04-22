package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys = new Object[MAX_SIZE];
    private final Object[] values = new Object[MAX_SIZE];

    private static Object[] removeNull(Object[] arr1, Object[] arr2) {
        int newSize = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arr1[i] != null || arr2[i] != null) {
                arr1[newSize++] = arr1[i];
            }
        }

        return Arrays.copyOf(arr1, newSize);
    }

    private Object indexOf(Object[] keys, Object key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        Object[] trimmedKeys = removeNull(keys, values);
        Object[] trimmedValues = removeNull(values, keys);
        Object index = indexOf(trimmedKeys, key);
        return index == null ? null : (V) trimmedValues[(int) index];
    }

    @Override
    public int size() {
        Object[] trimmedKeys = removeNull(keys, values);
        return trimmedKeys.length;
    }
}
