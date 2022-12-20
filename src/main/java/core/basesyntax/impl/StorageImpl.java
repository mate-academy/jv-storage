package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_STORAGE_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size; i++) {
            if ((keyArray[i] == null && valueArray[i] == null)) {
                keyArray[i] = key;
                valueArray[i] = value;
                size++;
                return;
            }
            if ((key == null && keyArray[i] == null)
                    || (key != null && key.equals(keyArray[i]))) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
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
