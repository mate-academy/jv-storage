package core.basesyntax;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
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
        if (index >= 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
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
