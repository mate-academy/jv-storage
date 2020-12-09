package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] boxes;
    private int cellNumber;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        boxes = new Object[MAX_ITEMS_NUMBER];
        cellNumber = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < cellNumber; i++) {
            if (key != null && key.equals(keys[i])) {
                keys[i] = key;
                boxes[i] = value;
            }
        }
        keys[cellNumber] = key;
        boxes[cellNumber] = value;
        cellNumber++;
    }

    @Override
    public V get(K key) {
        V box = null;
        for (int i = 0; i < cellNumber; i++) {
            if (key == null && keys[i] == null) {
                box = (V) boxes[i];
            }
            if (keys[i] == null) {
                continue;
            }
            if (keys[i].equals(key)) {
                box = (V) boxes[i];
            }
        }
        return box;
    }
}
