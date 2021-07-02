package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;
    private int size = 0;

    private final Object[][] resultArray = new Object[ARRAY_MAX_SIZE][2];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && resultArray[i][0] == null
                    || key != null && key.equals(resultArray[i][0])) {
                resultArray[i][0] = key;
                resultArray[i][1] = value;
                return;
            }
        }
        resultArray[size][0] = key;
        resultArray[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < resultArray.length; i++) {
            if (key == resultArray[i][0] || key != null && key.equals(resultArray[i][0])) {
                //noinspection unchecked
                return (V) resultArray[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
