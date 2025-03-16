package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private Object[][] objectArray = new Object[2][MAX_SIZE];

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if ((get(key) != null)) {
                objectArray[1][i] = value;
                return;
            } else if (objectArray[0][i] == null && objectArray[1][i] == null) {
                objectArray[0][i] = key;
                objectArray[1][i] = value;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((objectArray[0][i] != null && objectArray[0][i].equals(key))
                    || (key == objectArray[0][i])) {
                return (V) objectArray[1][i];
            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }
}
