package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private K key;
    private V value;
    private final Object[] keyKeep = new Object[MAX_SIZE_ARRAY];
    private final Object[] valueKeep = new Object[MAX_SIZE_ARRAY];
    private int storageIndex = -1;

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    private int getFoundIndex(Object[] keyArray, K key, int lengthKeyArray) {
        for (int i = 0; i < lengthKeyArray; i++) {
            if (Objects.equals(key,keyArray[i])) {
                return i;
            }
        }
        return MAX_SIZE_ARRAY;
    }

    @Override
     public void put(K key, V value) {
        int lengthKeyArray = storageIndex + 1;
        int foundIndex = getFoundIndex(keyKeep,key,lengthKeyArray);
        if (foundIndex == MAX_SIZE_ARRAY) {
            storageIndex = size();
            keyKeep [storageIndex] = key;
            valueKeep [storageIndex] = value;
        } else {
            valueKeep[foundIndex] = value;
            keyKeep[foundIndex] = key;
        }
    }

    @Override
    public V get(K key) {
        int lengthKeyArray = storageIndex + 1;
        int foundIndex = getFoundIndex(keyKeep, key,lengthKeyArray);
        if (foundIndex == MAX_SIZE_ARRAY) {
            return null;
        }
        return (V) valueKeep[foundIndex];
    }

    @Override
    public int size() {
        return storageIndex + 1;
    }
}

