package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;

    private final K[] arrayKey;
    private final V[] arrayValue;
    private int size;

    public StorageImpl() {
        arrayKey = (K[]) new Object[ARRAY_MAX_SIZE];
        arrayValue = (V[]) new Object[ARRAY_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i]
                    || arrayKey[i] != null && arrayKey[i].equals(key)) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayKey[size] = key;
        arrayValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
                return arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
