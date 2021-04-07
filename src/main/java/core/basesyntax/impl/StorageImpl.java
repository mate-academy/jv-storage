package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private K[] keysArray;
    private V[] valueArray;
    private int count;

    public StorageImpl() {
        keysArray = (K[]) new Object[SIZE];
        valueArray = (V[]) new Object[SIZE];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keysArray[count] = key;
        valueArray[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
