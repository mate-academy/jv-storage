package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_LENGTH = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_LENGTH];
        values = (V[]) new Object[DEFAULT_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        boolean keySearches = false;
        for (int a = 0; a < DEFAULT_LENGTH; a++) {
            if (keys[a] == key || keys[a] != null && keys[a].equals(key)) {
                values[a] = value;
                keySearches = true;
                break;
            }
        }
        if (keySearches == false) {
            for (int a = 0; a < DEFAULT_LENGTH; a++) {
                if (keys[a] == null && values[a] == null) {
                    keys[a] = key;
                    values[a] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int a = 0; a < DEFAULT_LENGTH; a++) {
            if (keys[a] == key || keys[a] != null && keys[a].equals(key)) {
                return values[a];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int a = 0; a < DEFAULT_LENGTH; a++) {
            if (keys[a] == null && values[a] == null) {
                return size;
            }
            size++;
        }
        return DEFAULT_LENGTH;
    }
}
