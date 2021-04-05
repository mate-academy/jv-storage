package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private static final int WRONG_RANGE = 11;
    private static final String NULL_EXPRESSION = "null";
    private int size = 0;
    private final String[] arrayOfKeys = new String[MAX_RANGE];
    private final String[] arrayOfValues = new String[MAX_RANGE];

    @Override
    public void put(K key, V value) {
        int numberOfSame = checkIfUniqueKey(key);

        if (numberOfSame == WRONG_RANGE) {
            if (key != null) {
                arrayOfKeys[size] = key.toString();
            } else {
                arrayOfKeys[size] = NULL_EXPRESSION;
            }
            arrayOfValues[size] = value != null ? value.toString() : NULL_EXPRESSION;
            size++;
        } else {
            arrayOfValues[numberOfSame] = value.toString();
        }
    }

    private int checkIfUniqueKey(K key) {
        int indexOfSame = WRONG_RANGE;

        if (key == null) {
            key = (K) NULL_EXPRESSION;
        }
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (key.toString().equals(arrayOfKeys[i])) {
                indexOfSame = i;
            }
        }
        return indexOfSame;
    }

    @Override
    public V get(K key) {
        V valueOfKey = null;
        int count = 0;
        boolean isPresentKey = isPresentKey(key);

        if (!isPresentKey) {
            return null;
        }

        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (count != 0) {
                return valueOfKey;
            }
            if (arrayOfKeys[i].equals(NULL_EXPRESSION) && key == null) {
                valueOfKey = (V) arrayOfValues[i];
                count++;
            } else if (key != null && arrayOfKeys[i].equals(key.toString())) {
                valueOfKey = (V) arrayOfValues[i];
                count++;
            }
        }
        return valueOfKey;
    }

    private boolean isPresentKey(K key) {
        boolean isPresentInArray = true;
        int count = 0;

        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (arrayOfKeys[i] == null) {
                continue;
            } else if (arrayOfKeys[i].equals(NULL_EXPRESSION) && key == null) {
                count++;
                break;
            } else if (key != null && arrayOfKeys[i].equals(key.toString())) {
                count++;
                break;
            }
        }
        if (count == 0) {
            isPresentInArray = false;
        }
        return isPresentInArray;
    }

    @Override
    public int size() {
        return size;
    }
}
