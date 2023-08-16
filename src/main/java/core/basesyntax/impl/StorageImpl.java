package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int AMOUNT_OF_OBJECTS = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private int currentIndex = 0;

    private Object[][] array;

    public StorageImpl() {
        array = new Object[MAX_SIZE][AMOUNT_OF_OBJECTS];
    }

    @Override
    public void put(K key, V value) {
        if (currentIndex < MAX_SIZE) {
            int index = findKeyIndex(key);
            if (index == -1) {
                array[currentIndex][KEY_INDEX] = key;
                array[currentIndex][VALUE_INDEX] = value;
                currentIndex++;
            } else {
                array[index][VALUE_INDEX] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentIndex; i++) {
            if (isSameKey(key, i)) {
                return (V) array[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < currentIndex; i++) {
            if (isSameKey(key, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSameKey(K key, int index) {
        return (key == null && array[index][KEY_INDEX] == null)
                || (key != null && key.equals(array[index][KEY_INDEX]));
    }
}
