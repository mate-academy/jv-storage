package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_KEYS_NUMBER = 10;
    private final Object[] keys = new Object[MAX_KEYS_NUMBER];
    private final Object[] values = new Object[MAX_KEYS_NUMBER];
    private int numberOfKeys = 0;

    @Override
    public void put(K key, V value) {
        int index = -1;

        for (int i = 0; i < numberOfKeys; i++) {
            if (((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key)))) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            keys[numberOfKeys] = key;
            values[numberOfKeys] = value;
            numberOfKeys++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numberOfKeys; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfKeys;
    }
}

