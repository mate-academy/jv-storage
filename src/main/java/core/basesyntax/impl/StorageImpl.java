package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;
    private int pointer = 0;

    public StorageImpl() {
        this.arrayOfValues = (V[]) new Object[ARRAY_SIZE];
        this.arrayOfKeys = (K[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int pos;
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (pointer != 0 && (pos = getKeyPos(key)) >= 0) {
                arrayOfKeys[pos] = key;
                arrayOfValues[pos] = value;
            } else {
                putPairOnPosition(key, value, pointer);
                pointer++;
            }
        }
    }

    public void putPairOnPosition(K key, V value, int pos) {
        arrayOfKeys[pos] = key;
        arrayOfValues[pos] = value;
    }

    private int getKeyPos(K key) {
        for (int i = 0; i < pointer; i++) {
            if (isEquals(key, arrayOfKeys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEquals(K key, K key1) {
        if (key == null) {
            return key1 == null;
        }
        return key.equals(key1);
    }

    @Override
    public V get(K key) {
        int pos;
        if (pointer > 0 && (pos = getKeyPos(key)) >= 0) {
            return arrayOfValues[pos];
        }
        return null;
    }

    @Override
    public int size() {
        return pointer;
    }
}
