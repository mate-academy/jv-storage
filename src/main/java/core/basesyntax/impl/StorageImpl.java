package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int KEY_MISSING = -1;
    public static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getPositionByKey(key);
        if (keyPosition != KEY_MISSING) {
            values[keyPosition] = value;
            return;
        }

        this.keys[size] = key;
        this.values[size] = value;
        ++size;
    }

    @Override
    public V get(K key) {
        int valuePosition = getPositionByKey(key);
        return valuePosition == KEY_MISSING ? null : values[valuePosition];
    }

    @Override
    public int size() {
        return size;
    }

    private int getPositionByKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return KEY_MISSING;
    }
}
