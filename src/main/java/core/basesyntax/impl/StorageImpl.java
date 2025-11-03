package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[ARRAY_SIZE];
        values = new Object[ARRAY_SIZE];
    }

    private int indexOf(K key) {
        int index = -1;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                index = i;
                break;
            } else if (keys[i] != null && keys[i].equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }
    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null && values[i] == null) {
                    keys[i] = key;
                    index = i;
                    break;
                }
            }
        }
        if (index == -1) {
            throw new RuntimeException("Storage is full");
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return (V)values[index];
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (keys[i] != null || (keys[i] == null && values[i] != null)) {
                size++;
            }
        }
        return size;
    }
}
