package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);

        if (index != -1) {
            values[index] = value;
        } else {
            ensureCapacity();
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);

        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean keyEquals(Object storedKey, K newKey) {
        return Objects.equals(storedKey, newKey);
    }

    private void ensureCapacity() {
        if (size >= keys.length) {
            int newCapacity = keys.length * 2;
            keys = Arrays.copyOf(keys, newCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }
    }
}
