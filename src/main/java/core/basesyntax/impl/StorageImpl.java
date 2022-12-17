package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private int size = 0;
    private K[] arrayKeys = (K[]) new Object[MAX_SIZE];
    private V[] arrayValues = (V[]) new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if ((arrayKeys[i] != null && arrayKeys[i].equals(key))
                        || ((arrayKeys[i] == key) && (arrayValues[i] != null))) {
                arrayValues[i] = value;
                arrayKeys[i] = key;
                return;
            }
        }
        arrayKeys[size] = key;
        arrayValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if ((arrayKeys[i] != null && arrayKeys[i].equals(key))
                    || (arrayKeys[i] == key)) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
