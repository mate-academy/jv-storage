package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_ROW = 0;
    private static final int VALUE_ROW = 1;
    private static final int NUMBER_OF_ELEMENTS = 10;
    private static final int NUMBER_OF_ROW = 2;
    private Object[] keys;
    private Object[] values;
    private int storageLength;

    public StorageImpl() {
        keys = new Object[NUMBER_OF_ELEMENTS];
        values = new Object[NUMBER_OF_ELEMENTS];
        storageLength = 0;
    }

    @Override
    public void put(K key, V value) {
        int counter = Math.min(getCounterByKey(key), storageLength);
        keys[counter] = key;
        values[counter] = value;
        storageLength += getCounterByKey(key) < storageLength ? 0 : 1;
    }

    @Override
    public V get(K key) {
        int counter = getCounterByKey(key);
        return (V) values[counter];
    }

    @Override
    public int size() {
        return storageLength;
    }

    private int getCounterByKey(K key) {
        int counter = 0;
        for (int i = 0; i < storageLength; i++) {
            if ((keys[i] == null
                       && values[i] != null
                       && key == null)
                    || (keys[i] != null
                       && keys[i].equals(key))) {
                return counter;
            }
            counter++;
        }
        return counter;
    }
}
