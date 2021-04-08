package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final Object[] valueArray = new Object[MAX_ARRAY_SIZE];
    private final Object[] keyArray = new Object[MAX_ARRAY_SIZE];
    private int counter;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
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
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
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
