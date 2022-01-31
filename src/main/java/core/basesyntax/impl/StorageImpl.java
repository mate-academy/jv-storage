package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;
    private K[] arrayKey;
    private V[] arrayValue;
    private int size;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_CAPACITY];
        arrayValue = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if (arrayKey[i] == null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                size++;
                break;
            }
            if ((key != null && key.equals(arrayKey[i])) || key == arrayKey[i]) {
                arrayValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(arrayKey[i])) || key == arrayKey[i]) {
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
