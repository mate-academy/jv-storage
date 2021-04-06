package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_IN_ARRAY = 0;
    private static final int VALUE_IN_ARRAY = 1;
    private static final int KEY_VALUE_PAIR_LENGTH = 2;

    private int arrayLengthCounter = 0;
    private Object[][] newArray = new Object[0][0];

    @Override
    public void put(K key, V value) {
        arrayLengthCounter++;
        if (newArray.length > 0 && get(key) == null) {
            Object[][] tempArray = newArray;
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i][KEY_IN_ARRAY] = newArray[i][KEY_IN_ARRAY];
                tempArray[i][VALUE_IN_ARRAY] = newArray[i][VALUE_IN_ARRAY];
            }
            reassignNewArray();
            for (int i = 0; i < tempArray.length; i++) {
                newArray[i][KEY_IN_ARRAY] = tempArray[i][KEY_IN_ARRAY];
                newArray[i][VALUE_IN_ARRAY] = tempArray[i][VALUE_IN_ARRAY];
            }
            addKeyValuePair(key, value);
        } else if (newArray.length > 0 && get(key) != null) {
            for (int i = 0; i < newArray.length; i++) {
                if (newArray[KEY_IN_ARRAY][0] == null ? key == null
                        : newArray[KEY_IN_ARRAY][0].equals(key)) {
                    newArray[i][KEY_IN_ARRAY] = key;
                    newArray[i][VALUE_IN_ARRAY] = value;
                }
            }
        } else {
            reassignNewArray();
            addKeyValuePair(key, value);
        }
    }

    private void reassignNewArray() {
        newArray = new Object[arrayLengthCounter][KEY_VALUE_PAIR_LENGTH];
    }

    private void addKeyValuePair(K key, V value) {
        newArray[arrayLengthCounter - 1][KEY_IN_ARRAY] = key;
        newArray[arrayLengthCounter - 1][VALUE_IN_ARRAY] = value;
    }

    @Override
    public V get(K key) {
        if (newArray.length == 0) {
            return null;
        }

        for (Object[] objects : newArray) {
            if ((objects[KEY_IN_ARRAY] == null ? key == null
                    : objects[KEY_IN_ARRAY].equals(key))) {
                return (V) objects[VALUE_IN_ARRAY];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return newArray.length;
    }
}
