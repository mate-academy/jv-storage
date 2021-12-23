package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[][] objectArray = new Object[2][10];

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < objectArray[0].length; i++) {
            if ((objectArray[0][i] == null && objectArray[1][i] == null)
                    || (objectArray[0][i] == null && key == null)
                    || (objectArray[0][i] != null && objectArray[0][i].equals(key))) {
                objectArray[0][i] = key;
                objectArray[1][i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < objectArray[0].length; i++) {
            if (objectArray[0][i] != null && objectArray[0][i].equals(key)) {
                return (V) objectArray[1][i];
            }
            if (key == null && objectArray[0][i] == null && objectArray[1][i] != null) {
                return (V) objectArray[1][i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < objectArray[0].length; i++) {
            if (objectArray[1][i] != null || objectArray[0][i] != null) {
                result++;
            }
        }
        return result;
    }
}
