package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private int size;
    private final K[] keys = (K[]) new Object[MAX_RANGE];
    private final V[] values = (V[]) new Object[MAX_RANGE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && key == keys[i])) {
                if (values[i] != null) {
                    values[i] = value;
                } else {
                    values[i] = value;
                    size++;
                }
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
        int count = 0;
        boolean isPresentKey = isPresentKey(key);

        if (!isPresentKey) {
            return null;
        }

        for (int i = 0; i < keys.length; i++) {
            if (count != 0) {
                return valueOfKey;
            }
            if (keys[i] == null && key == null) {
                valueOfKey = values[i];
                count++;
            } else if (key != null && keys[i] != null
                    && keys[i].toString().equals(key.toString())) {
                valueOfKey = values[i];
                count++;
            }
        }
        return valueOfKey;
    }

    private boolean isPresentKey(K key) {
        boolean isPresentInArray = true;
        int count = 0;

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                count++;
                break;
            } else if (key == null && keys[i] != null
                    && keys[i].equals("null")) {
                count++;
                break;
            } else if (key != null && keys[i] != null
                    && keys[i].toString().equals(key.toString())) {
                count++;
                break;
            }
        }
        if (count == 0) {
            isPresentInArray = false;
        }
        return isPresentInArray;
    }

    @Override
    public int size() {
        return size;
    }
}
