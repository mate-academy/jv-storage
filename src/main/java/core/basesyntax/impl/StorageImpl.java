package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[][] keyValue = new Object[MAX_SIZE][2];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyValue[i][0] == null
                    || key != null && key.equals(keyValue[i][0])) {
                keyValue[i][1] = value;
                return;
            }
        }
        keyValue[size][0] = key;
        keyValue[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (Object[] objects : keyValue) {
            if (key == objects[0] && key == null
                    || key != null && key.equals(objects[0])) {
                return (V) objects[1];
            }
        }
        return null;
    }
    
    @Override
    public int size() {
        return size;
    }
}
