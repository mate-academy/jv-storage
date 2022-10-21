package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    
    public StorageImpl() {
        keys = new Object[MAX_NUMBER];
        values = new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == values[i] && key != null && value != null)
                    || (key == keys[i] && values[i] != null)
                    || (key == keys[i] && value != null)
                    || (keys[i] != null && keys[i].equals(key))) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || key == keys[i] && values[i] != null) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Object value : values) {
            if (value != null) {
                size++;
            }
        }
        return size;
    }
}
