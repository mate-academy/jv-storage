package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAXIMUM_ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_ARRAY_SIZE];
        values = (V[]) new Object[MAXIMUM_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            int index = getIndexByKey(key);
            if (index != -1) {
                values[index] = value;
            }
        } else if (size <= keys.length) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is already filled. Can not add new elements");
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return (index != -1) ? values[index] : null;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
