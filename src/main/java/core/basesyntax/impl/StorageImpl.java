package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_SIZE = 10;

    K[] keyArr = (K[])new Object[ARRAY_SIZE];
    V[] valArr = (V[])new Object[ARRAY_SIZE];
    private int pos = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pos; i++) {
            if (key != null && keyArr[i] != null) {
                if (keyArr[i].equals(key)) {
                    valArr[i] = value;
                    return;
                }
            } else {
                if (keyArr[i] == null && key == null) {
                    valArr[i] = value;
                    return;
                }
            }
        }
        keyArr[pos] = key;
        valArr[pos] = value;
        pos++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < pos; i ++) {
            if (keyArr[i] != null && key != null) {
                if (keyArr[i].equals(key)) {
                    return valArr[i];
                }
            } else {
                if (keyArr[i] == null && key == null) {
                    return valArr[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return pos;
    }
}
