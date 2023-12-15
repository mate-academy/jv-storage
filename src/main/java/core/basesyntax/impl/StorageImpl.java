package core.basesyntax.impl;

import core.basesyntax.Storage;

// import javax.swing.*;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private static final int LAST_ELEMENT_INDEX = MAX_ARRAY_LENGTH - 1;
    private K[] keys;
    private V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    public void getRewrittenKeysArray() {
        boolean notNullFound = false;
        for (int i = LAST_ELEMENT_INDEX; i >= 0; i--) {
            if (!notNullFound) {
                if (keys[i] == null) {
                    keys[i] = (K) "rewritten";
                } else {
                    notNullFound = true;
                    i++;
                }
            } else {
                for (int j = 0; j < i; j++) {
                    if (keys[j] == keys[i] || keys[j] != null && keys[j].equals(keys[i])) {
                        keys[j] = (K) "overwritten";
                        storageSize--;
                    }
                }
            }
        }
    }

    @Override
    public void put(K key, V value) {
        keys[storageSize] = key;
        values[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        getRewrittenKeysArray();
        V result = null;
        for (int i = 0; i < keys.length; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    result = values[i];
                }
            } else {
                if (key.equals(keys[i])) {
                    result = values[i];
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
