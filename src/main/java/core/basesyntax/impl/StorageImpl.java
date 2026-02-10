package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    private int indexOf(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == null && key == null) {
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

        if (index == -1 && size < MAX_SIZE) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (keys[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    size++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == null && index != -1) {
                return null;
            } else if (index != -1) {
                return values[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
