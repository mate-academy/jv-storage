package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private boolean hasNullKey;
    private V nullKeyValue;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
        this.hasNullKey = false;
        this.nullKeyValue = null;
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (!hasNullKey) {
                hasNullKey = true;
                nullKeyValue = value;
                size++;
            } else {
                nullKeyValue = value;
            }
            return;
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            resize();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        if (key == null) {
            return nullKeyValue;
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        int newSize = keys.length * 2;
        keys = Arrays.copyOf(keys, newSize);
        values = Arrays.copyOf(values, newSize);
    }
}
