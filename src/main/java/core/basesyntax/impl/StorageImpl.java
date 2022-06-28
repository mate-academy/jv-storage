package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int sizeCount;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        sizeCount = 0;
    }

    @Override
    public void put(K key, V value) {
        if (keyIndex(key) >= 0) {
            values[keyIndex(key)] = value;
            return;
        }
        keys[sizeCount] = key;
        values[sizeCount] = value;
        sizeCount++;
    }

    @Override
    public V get(K key) {
        if (keyIndex(key) >= 0) {
            return values[keyIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCount;
    }

    private int keyIndex(K key) {
        for (int i = 0; i < sizeCount; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

}
