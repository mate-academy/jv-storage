package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int SIZE = 10;
    public static final int CAPACITY = 2;
    public static final int KEY_ELEMENT = 0;
    public static final int VALUE_ELEMENT = 1;

    private Object[][] storage = new Object[SIZE][CAPACITY];
    private int currentPosition = 0;

    @Override
    public void put(K key, V value) {
        int keyPosition = getKeyPosition(key);
        if (keyPosition == -1) {
            storage[currentPosition][KEY_ELEMENT] = key;
            storage[currentPosition][VALUE_ELEMENT] = value;
            currentPosition++;
        } else {
            storage[keyPosition][VALUE_ELEMENT] = value;
        }

    }

    @Override
    public V get(K key) {
        int keyPosition = getKeyPosition(key);
        return (V) (keyPosition != -1 ? storage[keyPosition][VALUE_ELEMENT] : null);
    }

    @Override
    public int size() {
        return currentPosition;
    }

    public int getKeyPosition(K key) {
        for (int i = 0; i < currentPosition; i++) {
            if (storage[i][KEY_ELEMENT] == key
                    || (storage[i][KEY_ELEMENT] != null
                    && storage[i][KEY_ELEMENT].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
