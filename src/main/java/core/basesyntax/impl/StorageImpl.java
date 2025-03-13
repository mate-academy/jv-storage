package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != NOT_FOUND) {
            values[index] = value; // Replace the existing value
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != NOT_FOUND) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (areEqual(keys[i], key)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private boolean areEqual(Object obj1, Object obj2) {
        if (obj1 == null) {
            return obj2 == null;
        } else {
            return obj1.equals(obj2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Storage [");
        for (int i = 0; i < size; i++) {
            sb.append("(")
                    .append(keys[i])
                    .append(", ")
                    .append(values[i])
                    .append(")");
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
