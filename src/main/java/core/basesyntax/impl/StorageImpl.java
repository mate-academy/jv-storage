package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        while (i < MAX_ITEMS_NUMBER) {
            if (keys[i] == null && values[i] == null
                    || keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                break;
            } else {
                i++;
            }
        }
    }

    @Override
    public V get(K key) {
        int j = 0;
        while (j < MAX_ITEMS_NUMBER) {
            if (keys[j] != null && keys[j].equals(key)) {
                break;
            } else if (keys[j] == null && key == null) {
                break;
            } else {
                j++;
            }
        }
        return j == MAX_ITEMS_NUMBER ? null : (V) values[j];
    }

    @Override
    public int size() {
        int i = 0;
        while (i < MAX_ITEMS_NUMBER) {
            if (keys[i] != null || values[i] != null) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
