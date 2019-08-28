package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int counter = 0;
    private Object[] keyArray = new Object[16];
    private Object[] valueArray = new Object[16];

    private int existsKey(K key) {
        for (int i = 0; i < counter; i++) {
            if ((keyArray[i] == null && key == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    private void resizeArray() {
        Object[] newKeyArray = Arrays.copyOf(keyArray, keyArray.length * 2);
        Object[] newValueArray = Arrays.copyOf(valueArray, valueArray.length * 2);
        keyArray = newKeyArray;
        keyArray = newValueArray;
    }

    @Override
    public V get(K key) {
        int i = existsKey(key);
        if (i >= 0) {
            return (V) valueArray[i];
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = existsKey(key);
        if (index >= 0) {
            valueArray[index] = value;
        } else {
            if (counter >= keyArray.length) {
                resizeArray();
            }
            keyArray[counter] = key;
            valueArray[counter] = value;
            counter++;
        }
    }
}

