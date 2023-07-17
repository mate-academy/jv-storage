package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int KEY_MISSING = -1;
    private K[] keys;
    private V[] values;
    private int sizeArray;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
        sizeArray = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyPosition = getPositionByKey(key);
        if (keyPosition != KEY_MISSING) {
            values[keyPosition] = value;
            return;
        }

        this.keys[sizeArray] = key;
        this.values[sizeArray] = value;
        ++sizeArray;
    }

    @Override
    public V get(K key) {
        int valuePosition = getPositionByKey(key);
        return valuePosition == KEY_MISSING ? null : values[valuePosition];
    }

    @Override
    public int size() {
        return sizeArray;
    }

    private int getPositionByKey(K key) {
        for (int i = 0; i < sizeArray; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return KEY_MISSING;
    }
}
