package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final String KEY_TYPE_NULL = "null";
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int INITIAL_USED_SPACE = 0;

    private K[] keys;
    private V[] values;
    private int usedSpace;

    public StorageImpl() {
        keys = (K[])new Object[MAX_ITEMS_NUMBER];
        values = (V[])new Object[MAX_ITEMS_NUMBER];
        usedSpace = INITIAL_USED_SPACE;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            key = (K) KEY_TYPE_NULL;
        }
        for (int i = 0; i < usedSpace; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[usedSpace] = key;
        values[usedSpace] = value;
        usedSpace++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            key = (K) KEY_TYPE_NULL;
        }
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return usedSpace;
    }
}
