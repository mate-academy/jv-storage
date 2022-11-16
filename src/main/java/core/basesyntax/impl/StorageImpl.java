package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_VALUE = 10;
    private int size;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_MAX_VALUE];
        valueArray = (V[]) new Object[ARRAY_MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);

        if (get(key) != null) {
            keyArray[index] = key;
            valueArray[index] = value;
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        return findIndex(key) < 0 ? null : valueArray[findIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == keyArray[i] || (keyArray[i] != null
                    && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
