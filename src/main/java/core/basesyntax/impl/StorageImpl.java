package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (now != 0) {
            for (int i = 0; i < now; i++) {
                if (keys[i] == null && key == null
                        || keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[now] = key;
        values[now] = value;
        now++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return now;
    }
}
