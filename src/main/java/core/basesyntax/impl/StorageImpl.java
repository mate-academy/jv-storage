package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private static final int ARRAY_MULTIPLIER = 2;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = createKeyArray();
        values = createValueArray();
    }

    @SuppressWarnings("unchecked")
    private K[] createKeyArray() {
        return (K[]) new Object[StorageImpl.DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    private V[] createValueArray() {
        return (V[]) new Object[StorageImpl.DEFAULT_SIZE];
    }

    public void put(K key, V value) {
        boolean found = false;
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    found = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * ARRAY_MULTIPLIER);
            values = Arrays.copyOf(values, size * ARRAY_MULTIPLIER);
        }
    }

    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
