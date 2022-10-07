package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int NOTHING_WAS_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndexInStorage(key);
        if (keyIndex == NOTHING_WAS_FOUND) {
            int cellIndex = getFreeCellIndex();
            keys[cellIndex] = key;
            values[cellIndex] = value;
            size++;
        } else {
            size += values[keyIndex] == null ? 1 : 0;
            values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndexInStorage(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return NOTHING_WAS_FOUND;
    }

    private int getFreeCellIndex() {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keys[i] == null && values[i] == null) {
                return i;
            }
        }
        return NOTHING_WAS_FOUND;
    }
}
