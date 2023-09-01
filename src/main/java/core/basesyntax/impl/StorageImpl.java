package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT = 10;
    private K[] arrayKeys;
    private V[] arrayValues;
    private int storageLength;

    public StorageImpl() {
        arrayKeys = (K[]) new Object[MAX_ELEMENT];
        arrayValues = (V[]) new Object[MAX_ELEMENT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageLength; i++) {
            if (Objects.equals(key, arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[storageLength] = key;
        arrayValues[storageLength] = value;
        storageLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageLength; i++) {
            if (Objects.equals(key, arrayKeys[i])) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageLength;
    }
}
