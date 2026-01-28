package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int COUNT_OF_ELEMENTS = 10;
    private static int NO_SUCH_INDEX = -1;
    private Object[] keys = new Object[COUNT_OF_ELEMENTS];
    private Object[] values = new Object[COUNT_OF_ELEMENTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);

        if (index != -1) {
            values[index] = value;
            return;
        }

        if (size < COUNT_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);

        if (index == -1) {
            return null;
        }

        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                if (key == null) {
                    return i;
                }
            } else if (keys[i].equals(key)) {
                return i;
            }
        }
        return NO_SUCH_INDEX;
    }
}
