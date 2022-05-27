package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_VALUE = 10;
    private int size = 0;
    private final Object[] keyArray;
    private final Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[MAX_ARRAY_VALUE];
        valueArray = new Object[MAX_ARRAY_VALUE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            valueArray[size - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
