package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private int size;
    private final K[] keys = (K[]) new Object[MAX_RANGE];
    private final V[] values = (V[]) new Object[MAX_RANGE];

    @Override
    public void put(K key, V value) {

        if (key == null) {
            key = (K) "null";
        }
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        V valueOfKey = null;
        if (key == null) {
            key = (K) "null";
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                keys[i] = (K) "null";
            }
            if (keys[i].equals("null") && key.equals("null")) {
                valueOfKey = values[i];
                return valueOfKey;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                valueOfKey = values[i];
                return valueOfKey;
            }
        }
        return valueOfKey;
    }

    @Override
    public int size() {
        return size;
    }
}
