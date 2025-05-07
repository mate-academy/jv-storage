package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;
    private int storageLength;

    public StorageImpl() {
        keys = new Object[NUMBER_OF_ELEMENTS];
        values = new Object[NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = Math.min(getCounterByKey(key), storageLength);
        keys[index] = key;
        values[index] = value;
        storageLength += index < storageLength ? 0 : 1;
    }

    @Override
    public V get(K key) {
        int index = getCounterByKey(key);
        return (V) values[index];
    }

    @Override
    public int size() {
        return storageLength;
    }

    private int getCounterByKey(K key) {
        int index = 0;
        for (; index < storageLength; index++) {
            if (keys[index] == key || (keys[index] != null && keys[index].equals(key))) {
                return index;
            }
        }
        return index;
    }
}
