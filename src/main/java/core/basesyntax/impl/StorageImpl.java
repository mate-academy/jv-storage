package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int firstEmptyIndex;

    public StorageImpl() {
        firstEmptyIndex = 0;
        K[] keyArray = (K[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        V[] valueArray = (V[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
    }

    @Override
    public void put(K key, V value) {
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
