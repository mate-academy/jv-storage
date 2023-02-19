package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;
    private boolean storageContainsKey;

    public StorageImpl() {
        keys = new Object[MAX_STORAGE_ELEMENTS];
        values = new Object[MAX_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        storageContainsKey = false;
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                storageContainsKey = true;
                break;
            }
        }
        if (!storageContainsKey) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null && values[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                return i;
            }
        }
        return MAX_STORAGE_ELEMENTS;
    }
}
