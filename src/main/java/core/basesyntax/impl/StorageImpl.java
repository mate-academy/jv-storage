package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE_STORAGE];
        valueArray = (V[]) new Object[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if ((key == keyArray[i] && valueArray[i] != null)
                    || (key != null && key.equals(keyArray[i]))) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keyArray[i]) || (key != null && key.equals(keyArray[i]))) {
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
