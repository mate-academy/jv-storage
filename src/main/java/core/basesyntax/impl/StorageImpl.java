package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int WRONG_KEY = -1;
    private static final int MAX_SIZE = 10;
    private int size;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[])new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != WRONG_KEY) {
            valueArray[keyIndex] = value;
        } else if (MAX_SIZE > size) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return getKeyIndex(key) != WRONG_KEY ? valueArray[getKeyIndex(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return i;
            }
        }
        return WRONG_KEY;
    }
}
