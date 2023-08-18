package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 9;
    private int size;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        size = 0;
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (((values[i] != null && keys[i] == null) && key == null)
                    || (values[i] != null && keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < MAX_SIZE; i++) {
            if ((key == null
                    && values[i] != null
                    && keys[i] == null)
                    || (values[i] != null
                    && keys[i] != null
                    && keys[i].equals(key))) {
                result = (V) values[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
