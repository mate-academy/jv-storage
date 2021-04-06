package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;
    private int size;
    private final K[] arrayKey;
    private final V[] arrayValue;

    public StorageImpl() {
        arrayKey = (K[]) new Object [CAPACITY];
        arrayValue = (V[]) new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            int nullIs = 0;
            for (int i = 0; i < size; i++) {
                if (arrayKey[i] == null) {
                    arrayValue[i] = value;
                    nullIs = 1;
                }
            }
            if (nullIs == 0) {
                arrayKey[size] = key;
                arrayValue[size] = value;
                size++;
            }
        } else {
            int keyIs = 0;
            for (int i = 0; i < size; i++) {
                if (key.equals(arrayKey[i])) {
                    arrayKey[i] = key;
                    arrayValue[i] = value;
                    keyIs = 1;
                }
            }
            if (keyIs == 0) {
                arrayKey[size] = key;
                arrayValue[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (arrayKey[i] == null) {
                    return arrayValue[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(arrayKey[i])) {
                    return arrayValue[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
