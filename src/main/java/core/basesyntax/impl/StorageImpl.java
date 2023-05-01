package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        size = 0;
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = existKeyIndex(key);
        if (keyIndex != -1) {
            this.values[keyIndex] = value;
        } else {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int keyIndex = existKeyIndex(key);
        if (keyIndex != -1) {
            return (V) this.values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int existKeyIndex(K key) {
        for (int i = 0; i < this.size(); i++) {
            if (Objects.equals(this.keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
