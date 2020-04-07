package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int limit;

    public StorageImpl() {
        limit = 0;
        keys = (K[]) new Object[LENGTH];
        values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (!duplicateKey(key)) {
            this.keys[limit] = key;
            this.values[limit] = value;
            this.limit++;
        } else {
            for (int i = 0; i < LENGTH - 1; i++) {
                if (keys[i] == key) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH - 1; i++) {
            if (key == keys[i]
                    || (key != null) && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean duplicateKey(K key) {
        for (K test : keys) {
            if (test == key
                    || (test != null) && test.equals(key)) {
                return true;
            }
        }
        return false;
    }

}


