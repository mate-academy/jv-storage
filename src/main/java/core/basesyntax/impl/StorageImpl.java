package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int PAIR = 2;
    private final Object [][] keys = new Object[MAX_ITEMS_NUMBER][PAIR];
    private int size;

    public StorageImpl() {
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = find(key);
        if (index == -1) {
            keys[size][0] = key;
            keys[size++][1] = value;
        } else {
            keys[index][1] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = find(key);
        if (index != -1) {
            return (V) keys[index][1];
        }
        return null;
    }

    public int find(K key) {
        int index = -1;

        for (int j = 0; j < MAX_ITEMS_NUMBER; j++) {
            if ((key != null && key.equals(keys[j][0]))
                    || (key == null && (keys[j][0] == null & keys[j][1] != null))) {
                index = j;
                break;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }
}
