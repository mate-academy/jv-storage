package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUMBER = 10;
    private int size;
    private final K[] keysArray;
    private final V[] valueArray;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[MAX_NUMBER];
        this.valueArray = (V[]) new Object[MAX_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keysArray[size] = key;
        valueArray[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
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

