package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private final K [] keys = (K[]) new Object[MAX_SIZE_ARRAY];
    private final V [] values = (V[]) new Object[MAX_SIZE_ARRAY];
    private int storageIndex = -1;

    public StorageImpl() {
    }

    private int getFoundIndex(K[] keyArray, K key, int lengthKeyArray) {
        for (int i = 0; i < lengthKeyArray; i++) {
            if (Objects.equals(key,keyArray[i])) {
                return i;
            }
        }
        return MAX_SIZE_ARRAY;
    }

    @Override
     public void put(K key, V value) {
        int lengthKeyArray = size();
        int foundIndex = getFoundIndex(keys,key,lengthKeyArray);
        if (foundIndex == MAX_SIZE_ARRAY) {
            storageIndex = size();
            keys [storageIndex] = key;
            values [storageIndex] = value;
        } else {
            values[foundIndex] = value;
            keys[foundIndex] = key;
        }
    }

    @Override
    public V get(K key) {
        int lengthKeyArray = storageIndex + 1;
        int foundIndex = getFoundIndex(keys, key,lengthKeyArray);
        if (foundIndex == MAX_SIZE_ARRAY) {
            return null;
        }
        return values[foundIndex];
    }

    @Override
    public int size() {
        return storageIndex + 1;
    }
}

