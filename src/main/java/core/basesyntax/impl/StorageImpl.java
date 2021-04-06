package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NO_SUCH_INDEX = -1;
    private final Object[] storageArray;
    private final Object[] indexArray;
    private int elementsCount;

    public StorageImpl() {
        storageArray = new Object[ARRAY_SIZE];
        indexArray = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == NO_SUCH_INDEX) {
            indexArray[elementsCount] = key;
            storageArray[elementsCount] = value;
            elementsCount++;
        } else {
            indexArray[index] = key;
            storageArray[index] = value;
        }
    }

    public int getIndex(K key) {
        for (int i = 0; i < elementsCount; i++) {
            if (indexArray[i] != null && indexArray[i].equals(key) || indexArray[i] == key) {
                return i;
            }
        }
        return NO_SUCH_INDEX;
    }

    @Override
    public V get(K key) {
        return getIndex(key) == NO_SUCH_INDEX ? null : (V) storageArray[getIndex(key)];
    }

    @Override
    public int size() {
        return elementsCount;
    }
}
