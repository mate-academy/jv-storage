package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = null;
            values[size] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object storageImpl) {
        if (storageImpl == null) {
            return false;
        }
        if (storageImpl == this) {
            return true;
        }
        if (storageImpl instanceof StorageImpl) {
            StorageImpl current = (StorageImpl)storageImpl;
            return Objects.equals(this.keys, current.keys)
                    && Objects.equals(this.values, current.values)
                    && this.size == size;
        }
        return false;
    }
}
