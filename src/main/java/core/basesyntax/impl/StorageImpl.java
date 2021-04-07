package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int arrayLengthCounter;
    private Object[] keyArray = new Object[0];
    private Object[] valueArray = new Object[0];

    @Override
    public void put(K key, V value) {
        arrayLengthCounter++;
        if (keyArray.length == 0) {
            createNewArrays();
            addKeyValuePair(key, value);
        }
        if (keyArray.length > 0 && get(key) == null) {
            Object[] tempKeyArray = keyArray;
            Object[] tempValueArray = valueArray;
            createNewArrays();
            System.arraycopy(tempKeyArray, 0, keyArray, 0, tempKeyArray.length);
            System.arraycopy(tempValueArray, 0, valueArray, 0, tempValueArray.length);
            addKeyValuePair(key, value);
        } else {
            for (int i = 0; i < keyArray.length; i++) {
                if (keyArray[i] == null ? key == null : keyArray[i].equals(key)) {
                    keyArray[i] = key;
                    valueArray[i] = value;
                    break;
                }
            }
        }
    }

    private void createNewArrays() {
        keyArray = new Object[arrayLengthCounter];
        valueArray = new Object[arrayLengthCounter];
    }

    private void addKeyValuePair(K key, V value) {
        keyArray[arrayLengthCounter - 1] = key;
        valueArray[arrayLengthCounter - 1] = value;
    }

    @Override
    public V get(K key) {
        if (keyArray.length == 0) {
            return null;
        }

        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null ? key == null : keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyArray.length;
    }
}
