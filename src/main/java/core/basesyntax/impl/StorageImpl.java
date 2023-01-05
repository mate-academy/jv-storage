package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUM_OF_ITEMS = 10;
    private K[] keys = (K[]) new Object[MAX_NUM_OF_ITEMS];
    private V[] values = (V[]) new Object[MAX_NUM_OF_ITEMS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key) && values[i] != null) {
                values[i] = value;
                return;
            }
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
