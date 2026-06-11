package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private K[] keys;
    private V[] values;
    private boolean[] occupied;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_COUNT];
        values = (V[]) new Object[MAX_ELEMENTS_COUNT];
        occupied = new boolean[MAX_ELEMENTS_COUNT];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_COUNT; i++) {
            if (occupied[i] && keysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        for (int i = 0; i < MAX_ELEMENTS_COUNT; i++) {
            if (!occupied[i]) {
                keys[i] = key;
                values[i] = value;
                occupied[i] = true;
                count++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENTS_COUNT; i++) {
            if (occupied[i] && keysEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private boolean keysEqual(K a, K b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
}
