package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 11;
    //1 reserved for null, so limit set as 11 in case if none of the Keys is null
    private static final int NULL_DEFAULT_INDEX = 0;
    private int size = 0;
    private int[] indexes;
    private Object[] values;

    public StorageImpl() {
        values = new Object[MAX_ITEMS_NUMBER];
        indexes = new int[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (values[NULL_DEFAULT_INDEX] == null) {
                size++;
            }
            values[0] = value;
            return;
        }

        int index = key.hashCode();
        for (int i = 1; i < 9; i++) {
            if (indexes[i] == 0) {
                indexes[i] = index;
                values[i] = value;
                size++;
                break;
            }
            if (indexes[i] == index) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return (V)values[NULL_DEFAULT_INDEX];
        }
        int index = key.hashCode();
        for (int i = 1; i < 9; i++) {
            if (indexes[i] == index) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
