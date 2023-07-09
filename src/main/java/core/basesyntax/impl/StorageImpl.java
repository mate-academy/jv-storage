package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private final boolean[] occupied;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        occupied = new boolean[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size >= MAX_SIZE) {
                throw new RuntimeException("Storage is full");
            }
            index = findNextAvailableIndex();
            keys[index] = key;
            values[index] = value;
            occupied[index] = true;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (occupied[i] && (keys[i] == null ? key == null : keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    private int findNextAvailableIndex() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (!occupied[i]) {
                return i;
            }
        }
        return -1;
    }
}
