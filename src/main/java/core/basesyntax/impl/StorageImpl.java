package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final short MAX_LENGTH_STORAGE = 10;
    private final K[] keys = (K[]) new Object[MAX_LENGTH_STORAGE];
    private final V[] values = (V[]) new Object[MAX_LENGTH_STORAGE];
    private int length;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[length] = key;
        values[length] = value;
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        System.out.println("Can't find record with key: " + key);
        return null;
    }

    @Override
    public int size() {
        return length;
    }
}
