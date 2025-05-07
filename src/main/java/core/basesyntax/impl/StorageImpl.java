package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K [] keys;
    private V [] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            keys[index] = key;
            values[index] = value;
        } else if (size < MAX_ARRAY_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Array is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "StorageImpl{"
                + "keys="
                + Arrays.toString(keys)
                + System.lineSeparator()
                + ", values="
                + Arrays.toString(values)
                + ", size="
                + size
                + '}';
    }
}
