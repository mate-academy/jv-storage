package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CURRENT_INDEX = 0;
    private static final int DEFAULT_STORAGE = 1;
    private static final int MAXIMUM_STORAGE = 10;
    private static final int KEY_NOT_FOUND = -1;

    private int currentIndex;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        currentIndex = DEFAULT_CURRENT_INDEX;
        keys = (K[]) new Object[DEFAULT_STORAGE];
        values = (V[]) new Object[DEFAULT_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        boolean isValueReplaced = replaceIfKeyExists(key, value);

        if (!isValueReplaced) {
            widenTheArrayIfNeeded();
            keys[currentIndex] = key;
            values[currentIndex++] = value;
        }
    }

    private boolean replaceIfKeyExists(K key, V value) {
        int indexOfKey = findIndexOfKey(key);

        if (indexOfKey == KEY_NOT_FOUND) {
            return false;
        }

        values[indexOfKey] = value;
        return true;
    }

    private void widenTheArrayIfNeeded() {
        if (currentIndex > 0 && currentIndex < MAXIMUM_STORAGE) {
            keys = Arrays.copyOf(keys, keys.length + 1);
            values = Arrays.copyOf(values, values.length + 1);
        }
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return KEY_NOT_FOUND;
    }

    @Override
    public V get(K key) {
        int indexOfKey = findIndexOfKey(key);
        return (indexOfKey == KEY_NOT_FOUND) ? null : (V) values[indexOfKey];
    }

    @Override
    public int size() {
        return currentIndex;
    }
}
