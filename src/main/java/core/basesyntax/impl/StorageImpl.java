package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAY_SIZE];
    private V[] values = (V[]) new Object[ARRAY_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        boolean isTheSameKey = false;
        for (int j = 0; j < count; j++) {
            if (Objects.equals(key, keys[j]) && values[j] != null) {
                values[j] = value;
                isTheSameKey = true;
                break;
            }
        }

        if (!isTheSameKey) {
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                result = values[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return count;
    }
}


