package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int cellNumber;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        cellNumber = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < cellNumber; i++) {
            if ((key != null && keys[i] != null && key.equals(keys[i]))
                    || (key == null && keys[i] == null)) {
                values[i] = value;
                return;
            }
        }
        keys[cellNumber] = key;
        values[cellNumber] = value;
        cellNumber++;
    }

    @Override
    public V get(K key) {
        V box = null;
        for (int i = 0; i < cellNumber; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                box = (V) values[i];
            }
        }
        return box;
    }
}
