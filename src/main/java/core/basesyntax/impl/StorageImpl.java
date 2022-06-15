package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private int size;
    private K[] keys = (K[]) new Object[MAX_SIZE_ARRAY];
    private V[] values = (V[]) new Object[MAX_SIZE_ARRAY];

    @Override
    public void put(K key, V value) {
        Integer index = getIndex(key);
        if (index != null) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = getIndex(key);
        return index != null ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Integer getIndex(K key) {
        Integer result = null;
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == key && keys[i] == null)) {
                result = i;
            }
        }
        return result;
    }
}
