package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;

    private final K[] keys;
    private final V[] values;
    private int space;

    public StorageImpl() {
        keys = (K[]) Array.newInstance(Object.class, STORAGE_SIZE);
        values = (V[]) Array.newInstance(Object.class, STORAGE_SIZE);
    }

    public boolean verify(K k, K v) {
        return (k != null && k.equals(v) || k == v);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < space; i++) {
            if (verify(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[space] = key;
        values[space++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < space; i++) {
            if (verify(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return space;
    }
}
