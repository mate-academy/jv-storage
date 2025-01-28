package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int size;
    private boolean nullKeyPresent;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
        size = 0;
        nullKeyPresent = false;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullKeyPresent = true;
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value; // Заміна значення для ключа null
                    return;
                }
            }
            if (size < MAX_VALUE) {
                keys[size] = null;
                values[size] = value;
                size++;
            } else {
                throw new RuntimeException("Storage is full");
            }
            return;
        }
        for (int i = 0;i < size;i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_VALUE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageImpl)) {
            return false;
        }
        StorageImpl<K, V> storage = (StorageImpl<K, V>) obj;
        return Arrays.equals(keys, storage.keys) && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keys) ^ Arrays.hashCode(values);
    }
}
