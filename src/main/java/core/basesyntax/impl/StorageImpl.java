package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;

    private final K[] keysStorage = (K[]) new Object[STORAGE_SIZE];
    private final V[] valuesStorage = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            for (int i = 0; i < keysStorage.length; i++) {
                if (keysStorage[i] == null) {
                    valuesStorage[i] = value;
                    break;
                }
            }
        } else {
            for (int i = 0; i < keysStorage.length; i++) {
                if (key.equals(keysStorage[i])) {
                    valuesStorage[i] = value;
                    break;
                }
                if (keysStorage[i] == null && valuesStorage[i] == null) {
                    keysStorage[i] = key;
                    valuesStorage[i] = value;
                    break;
                }
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysStorage.length; i++) {
            if ((key == null && keysStorage[i] == null)
                    || (key != null && key.equals(keysStorage[i]))) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < valuesStorage.length; i++) {
            if (valuesStorage[i] != null) {
                count++;
            }
        }
        return count;
    }
}
