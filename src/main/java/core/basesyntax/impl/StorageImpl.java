package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;
    private final boolean[] occupied = new boolean[MAX_SIZE];

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null && occupied[i]) {
                return i;
            } else if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);

        if (index >= 0) {
            values[index] = value;
            return;
        }

        if (size < MAX_SIZE) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (keys[i] == null && !occupied[i]) {
                    keys[i] = key;
                    values[i] = value;
                    occupied[i] = true;
                    size++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
