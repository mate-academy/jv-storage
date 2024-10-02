package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;

    private StorageImpl(K[] keys,V[] values) {
        this.keys = keys;
        this.values = values;
    }

    @Override
    public void put(K key, V value) {
        int numberOfObjects = 0;
        int ifItWasFound = 0;

        for (int i = 0; i < keys.length; i++) {
            ifItWasFound = 0;
            if (keys[i].equals(key)) {
                values[i] = value;
                ifItWasFound++;
            }
        }

        if (ifItWasFound == 0) {
            keys[numberOfObjects] = key;
            values[numberOfObjects] = value;
            numberOfObjects++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            } else {throw new RuntimeException("don't find given key");
    }

    @Override
    public int size() {
        return keys.length;
    }
}
