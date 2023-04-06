package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
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
        int index = findKeyindex(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is Full");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyindex(key);
        if (index != -1) {
            return values[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyindex(K key) {
        for (int i = 0; i < size; i++) {
            if (customEquals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean customEquals(K obj1, K obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }
}
