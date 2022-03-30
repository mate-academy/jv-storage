package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_STORAGE_SIZE];
        values = (V[]) new Object[DEFAULT_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int existingIndex = searchKey(key);
        if (existingIndex >= 0) {
            values[existingIndex] = value;
            return;
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    public int searchKey(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && keys[i] != null && (key.equals(keys[i])))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int existingIndex = searchKey(key);
        if (existingIndex >= 0) {
            return values[existingIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
