package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_KEY_VALUE = 10;
    private static int VALUE = 2;
    private Object[][] array = new Object[MAX_KEY_VALUE][VALUE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_KEY_VALUE; i++) {
            if (array[i] != null) {
                array[i][0] = key;
                array[i][1] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_KEY_VALUE; i++) {
            if (array[i][0] != null && array[i][0].equals(key)) {
                return (V) array[i][1];
            }
        }
        return null;
    }
}
