package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl current = (StorageImpl) o;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], current.keys[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public void put(K key, V value) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                found = true;
                break;
            }
        }
        if (!found) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * 2);
            values = Arrays.copyOf(values, size * 2);
        }
        keys[size] = key;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
