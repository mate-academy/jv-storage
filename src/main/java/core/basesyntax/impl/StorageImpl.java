package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }
        for (int i = 0; i < size; i++) {
            if ((key == null && this.keys[i] == null)
                    || (key != null && key.equals(this.keys[i]))) {
                this.values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            int newSize = keys.length * 2;
            keys = Arrays.copyOf(keys, newSize);
            values = Arrays.copyOf(values, newSize);
        }
        this.keys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(this.keys[i])) {
                return (V) this.values[i];
            }
        }
        return null;
    }

    private V getNullKey() {
        for (int i = 0; i < size; i++) {
            if (this.keys[i] == null) {
                return (V) this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (this.keys[i] == null) {
                this.values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            int newSize = keys.length * 2;
            keys = Arrays.copyOf(keys, newSize);
            values = Arrays.copyOf(values, newSize);
        }
        this.keys[size] = null;
        this.values[size] = value;
        size++;
    }

}
