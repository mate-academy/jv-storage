package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_VOLUME = 10;
    private final Object[] arrayKey;
    private final Object[] arrayValue;

    public StorageImpl() {
        arrayKey = new Object[STORAGE_VOLUME];
        arrayValue = new Object[STORAGE_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (arrayKey[i] == null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                break;
            }

            if (arrayKey[i] == key || arrayKey[i] != null && arrayKey[i].equals(key)) {
                arrayValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (arrayKey[i] == key || arrayKey[i] != null && arrayKey[i].equals(key)) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (arrayKey[i] == null && arrayValue[i] == null) {
                return i;
            }
        }
        return 10;
    }
}
