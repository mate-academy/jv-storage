package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int maxNumber = 10;
    private int realSize = -1;
    private K[] keys = (K[]) new Object[maxNumber];
    private V[] values = (V[]) new Object[maxNumber];

    @Override
    public void put(K key, V value) {
        int foundKey = -1;
        for (int i = 0; i <= realSize; i++) {
            if (key == null && keys[i] == null) {
                foundKey = i;
                break;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                foundKey = i;
                break;
            }
        }
        if (foundKey == -1) {
            realSize++;
            keys[realSize] = key;
            values[realSize] = value;
        } else {
            values[foundKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int foundKey = -1;
        for (int i = 0; i <= realSize; i++) {
            if (key == null && keys[i] == null) {
                foundKey = i;
                break;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                foundKey = i;
                break;
            }
        }
        if (foundKey == -1) {
            return null;
        } else {
            return values[foundKey];
        }
    }

    @Override
    public int size() {
        return realSize + 1;
    }
}
