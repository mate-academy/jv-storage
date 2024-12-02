package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }

        StorageImpl<?, ?> other = (StorageImpl<?, ?>) obj;

        if (this.size != other.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            boolean mathFound = false;
            for (int j = 0; j < other.size; j++) {
                if (Objects.equals(this.keys[i], other.keys[j])
                        && Objects.equals(this.values[i], other.values[j])) {
                    mathFound = true;
                    break;
                }
            }

            if (!mathFound) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (int i = 0; i < size; i++) {
            result = 31 * result + Objects.hashCode(keys[i]);
            result = 31 * result + Objects.hashCode(values[i]);
        }
        return result;
    }
}
