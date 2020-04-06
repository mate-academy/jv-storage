package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private static final int STORAGE_PARAMETERS_COUNT = 2;
    private static final int KEYS_INDEX = 0;
    private static final int VALUES_INDEX = 1;
    private Object[][] objects;

    public StorageImpl() {
        objects = new Object[MAX_STORAGE_CAPACITY][STORAGE_PARAMETERS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i][KEYS_INDEX] == null && objects[i][VALUES_INDEX] == null) {
                objects[i][KEYS_INDEX] = key;
                objects[i][VALUES_INDEX] = value;
                break;
            } else if (objects[i][KEYS_INDEX] != null && objects[i][KEYS_INDEX].equals(key)) {
                objects[i][VALUES_INDEX] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Object[] object : objects) {
            if ((object[KEYS_INDEX] != null
                    && object[KEYS_INDEX].equals(key))
                    || key == object[KEYS_INDEX]) {
                return (V) object[VALUES_INDEX];
            }
        }
        return null;
    }
}
