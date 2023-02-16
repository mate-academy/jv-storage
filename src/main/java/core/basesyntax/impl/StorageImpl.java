package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;

    private K [] storegeOfKeys;
    private V [] storegeOfValues;
    private int sizeOfArrays;

    public StorageImpl() {
        storegeOfKeys = (K[]) new Object[ARRAY_SIZE];
        storegeOfValues = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfArrays; i++) {
            if (Objects.equals(key, storegeOfKeys[i])) {
                storegeOfValues[i] = value;
                return;
            }
        }
        storegeOfKeys[sizeOfArrays] = key;
        storegeOfValues[sizeOfArrays] = value;
        sizeOfArrays++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfArrays; i++) {
            if (Objects.equals(key, storegeOfKeys[i])) {
                return storegeOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfArrays;
    }
}
