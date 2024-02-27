package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INVALID_INDEX = -1;
    private static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int size;

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != INVALID_INDEX) {
            valueArray[index] = value;
            return;
        }
        valueArray[size] = value;
        keyArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != INVALID_INDEX) {
            return valueArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
