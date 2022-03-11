package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(Object key, Object value) {
        if (checkIfAlreadyExists(key, (V) value)) {
            return;
        }
        keyArray[size] = (K) key;
        valueArray[size] = (V) value;
        size++;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                return i;
            }
            return -1;
        }
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
