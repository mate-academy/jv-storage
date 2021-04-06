package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keyArray;
    private final Object[] valueArray;
    private int counter;

    public StorageImpl() {
        keyArray = new Object[MAX_ITEMS_NUMBER];
        valueArray = new Object[MAX_ITEMS_NUMBER];
        counter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key != null && key.equals(keyArray[i])
                    || key == keyArray[i]) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[counter] = key;
        valueArray[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == null && keyArray[i] == null
                    || key != null && key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
