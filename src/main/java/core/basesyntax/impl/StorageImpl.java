package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] arrayK;
    private V[] arrayV;
    private int size;

    public StorageImpl() {
        arrayK = (K[]) new Object[10];
        arrayV = (V[]) new Object[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        ++size;
        for (int i = 0; i < size; i++) {
            if (key == null && arrayK[i] == null && arrayV[i] != null) {
                arrayV[i] = value;
                size -= 1;
                break;
            } else if (arrayK[i] != null && arrayK[i].equals(key)) {
                arrayV[i] = value;
                size -= 1;
                break;
            } else if (i == (size - 1)) {
                arrayK[size - 1] = key;
                arrayV[size - 1] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && arrayK[i] == null) {
                return arrayV[i];
            } else if (arrayK[i] != null && arrayK[i].equals(key)) {
                return arrayV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
