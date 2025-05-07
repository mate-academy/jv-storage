package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private static final int VALUE_NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != VALUE_NOT_FOUND) {
            values[index] = value;
        } else {
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != VALUE_NOT_FOUND) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if ((keys[i] == key)
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return VALUE_NOT_FOUND;
    }
}
