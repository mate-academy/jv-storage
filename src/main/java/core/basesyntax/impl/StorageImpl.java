package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private final K[] keys;
    private final V[] values;
    private int count;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);

        if (index != -1) {
            values[index] = value;
            return;
        }

        if (count < MAX_SIZE) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);

        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return count;
    }

    private int indexOf(K key) {
        for (int i = 0; i < count; i++) {
            if (keysEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean keysEqual(K a, K b) {
        if (a == b) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.equals(b);
    }
}
