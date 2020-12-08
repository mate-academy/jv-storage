package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage {
    K[] keys = (K[]) new Object[MAX_ARRAY_LENGTH];
    V[] values = (V[]) new Object[MAX_ARRAY_LENGTH];
    int length = 0;
    private static final int MAX_ARRAY_LENGTH = 10;

    @Override
    public void put (Object key, Object value) {
        for (int i = 0;i < length;i++) {
            if(key == keys[i]) {
                keys[i] = (K) key;
                values[i] = (V) value;
            }
        }
        keys[length] = (K) key;
        values[length] = (V) value;
        length++;
    }

    @Override
    public V get(Object key) {
        for (int i = 0;i < length;i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }
}
