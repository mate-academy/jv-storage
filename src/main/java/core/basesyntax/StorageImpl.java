package core.basesyntax;

import java.util.Arrays;

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
        int index = indexOf(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (size >= keys.length) {
                expandCapacity();
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index >= 0 ? values[index] : null;
        }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return i;
            }
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private void expandCapacity() {
        int newSize = keys.length * 2;
        keys = Arrays.copyOf(keys, newSize);
        values = Arrays.copyOf(values, newSize);
    }
}

