package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int ARRAYS_ARE_EMPTY = 0;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (canAddWithSameKey(key)) {
            if (key != null && key.equals(keys[size - 1])) {
                keys[size - 1] = key;
                values[size - 1] = value;
                return;
            }
            if (keys[size - 1] == null) {
                values[size] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (size == ARRAYS_ARE_EMPTY) {
            return null;
        }
        return findValue(key);
    }

    @Override
    public int size() {
        return size;
    }

    private boolean canAddWithSameKey(K key) {
        if (size != ARRAYS_ARE_EMPTY) {
            return key != null && key.equals(keys[size - 1])
                    || key == null && keys[size - 1] == null;
        }
        return false;
    }

    private V findValue(K key) {
        int index = size;
        for (; index >= 0; index--) {
            if (key != null && key.equals(keys[index])
                    || keys[index] == key & values[index] != null) {
                return values[index];
            }
        }
        return values[size];
    }
}
