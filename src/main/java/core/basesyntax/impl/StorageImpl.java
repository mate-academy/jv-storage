package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NULL_KEY = 0; // place 0 in valueStorage array use if key == null.
    private V[] valueStorage = (V[]) new Object[10];
    private K[] keyStorage = (K[]) new Object[10];
    private int sizeExceptNull = 1; //two values that need to count size
    private int isNullKey = - 1;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            valueStorage[NULL_KEY] = value;
            isNullKey = 0;
            return;
        }
        for (int i = 1; i < sizeExceptNull; i++) {
            if (key.equals(keyStorage[i])) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[sizeExceptNull] = key;
        valueStorage[sizeExceptNull] = value;
        sizeExceptNull++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return valueStorage[NULL_KEY];
        }
        for (int i = 1; i < sizeExceptNull; i++) {
            if (key.equals(keyStorage[i])) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeExceptNull + isNullKey;
    }
}
