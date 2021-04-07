package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int counter = 0;
    private Object[] valueArray = new Object[10];
    private Object[] keyArray = new Object[10];

    @Override
    public void put(K key, V value) {
        if (counter != 0 && keyArray[counter - 1] == key || counter != 0
                && keyArray[counter - 1] != null
                && keyArray[counter - 1].equals(key)) {
            valueArray[counter - 1] = value;
        } else {
            keyArray[counter] = key;
            valueArray[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (size() != 0 && keyArray[i] == key || size() != 0
                    && keyArray[i] != null
                    && keyArray[i].equals(key)) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int fullSize = 10;
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                fullSize--;
            }
        }
        return fullSize;
    }
}
