package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE = 0;
    private int currentSize;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[INITIAL_SIZE];
        this.values = (V[]) new Object[INITIAL_SIZE];
        this.currentSize = INITIAL_SIZE;
    }

    @Override
    public void put(K key, V value) {
        boolean repeatKey = false;
        if (key == null) {
            for (int i = 0; i < currentSize; i++) {
                if (keys[i] == key) {
                    values[i] = value;
                    repeatKey = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    repeatKey = true;
                    break;
                }
            }
        }
        if (!repeatKey) {
            expandCapacity();
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;

        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < currentSize; i++) {
                if (keys[i] == key) {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    public void expandCapacity() {
        if (currentSize == keys.length) {
            int newCapacity = keys.length + 1;
            keys = Arrays.copyOf(keys, newCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }
    }
}
