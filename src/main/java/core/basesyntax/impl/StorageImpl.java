package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_ELEMENTS];
        values = (V[]) new Object[MAX_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int ifKeyWasFound;
        ifKeyWasFound = 0;
        for (int i = 0; i < size; i++) {
            if ((key != null && keys[i] != null && keys[i].equals(key))
                    || (key == null && keys[i] == null && values[i] != null)) {
                values[i] = value;
                ifKeyWasFound++;
            }
        }
        if (ifKeyWasFound == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            } else if (key == null) {
                if (keys[i] == key) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
