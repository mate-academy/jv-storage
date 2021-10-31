package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_ROW = 0;
    private static final int VALUE_ROW = 1;
    private static final int NUMBER_OF_ELEMENTS = 10;
    private static final int NUMBER_OF_ROW = 2;
    private Object[][] storage;
    private int storageLength;

    public StorageImpl() {
        storage = new Object[NUMBER_OF_ELEMENTS][NUMBER_OF_ROW];
        storageLength = 0;
    }

    @Override
    public void put(K key, V value) {
        int counter = Math.min(getCounterByKey(key), storageLength);
        storage[counter][KEY_ROW] = key;
        storage[counter][VALUE_ROW] = value;
        storageLength += getCounterByKey(key) < storageLength ? 0 : 1;
    }

    @Override
    public V get(K key) {
        int counter = getCounterByKey(key);
        return (V) storage[counter][VALUE_ROW];
    }

    @Override
    public int size() {
        return storageLength;
    }

    private int getCounterByKey(K key) {
        int counter = 0;
        for (int i = 0; i < storageLength; i++) {
            if ((storage[i][KEY_ROW] == null
                       && storage[i][VALUE_ROW] != null
                       && key == null)
                    || (storage[i][KEY_ROW] != null
                       && storage[i][KEY_ROW].equals(key))) {
                return counter;
            }
            counter++;
        }
        return counter;
    }
}
