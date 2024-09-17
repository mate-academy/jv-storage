package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
            if (isEquals(key, keys[i])) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (isEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(K key, K keys) {
        return key == keys || key != null && key.equals(keys);
    }
}
