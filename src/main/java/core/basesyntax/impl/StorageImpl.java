package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPITACITY = 10;
    private K[] keys = (K[]) new Object[MAX_CAPITACITY];
    private V[] values = (V[]) new Object[MAX_CAPITACITY];
    private int index = 0;
    private int storageCounter = 0;
    private boolean isExisting = false;

    @Override
    public void put(K key, V value) {
        isExisting = false;
        if (storageCounter != 0) {
            for (int i = 0;i < keys.length;i++) {
                if (key == null) {
                    if (key == keys[i]) {
                        index = i;
                        isExisting = true;
                        if (values[i] == null) {
                            storageCounter++;
                        }
                        break;
                    }
                } else if (key != null) {
                    if (key.equals(keys[i])) {
                        index = i;
                        isExisting = true;
                    }
                }
            }
        }

        if (isExisting) {
            values[index] = value;
        } else {
            keys[storageCounter] = key;
            values[storageCounter] = value;
            storageCounter++;
        }
    }

    @Override
    public V get(K key) {
        if (storageCounter > 0) {
            for (int i = 0;i < keys.length;i++) {
                if (key == null) {
                    if (key == keys[i]) {
                        return values[i];
                    }
                }
                if (key != null) {
                    if (key.equals(keys[i])) {
                        return values[i];
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageCounter;
    }
}
