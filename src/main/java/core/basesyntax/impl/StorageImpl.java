package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.keys = new Object[NUMBER_OF_ELEMENTS];
        this.values = new Object[NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            if (keys[i] == null && values[i] == null
                    || keys[i] == key && values[i] != null
                    || keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                size = i;
                break;
            }
        }
        return size;
    }
}
