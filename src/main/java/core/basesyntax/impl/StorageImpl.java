package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_VALUE = 10;
    private int size;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_MAX_VALUE];
        valueArray = (V[]) new Object[ARRAY_MAX_VALUE];
    }

    private int findIndex(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            keyArray[findIndex(key)] = key;
            valueArray[findIndex(key)] = value;
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        return findIndex(key) < 0 ? null : valueArray[findIndex(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
