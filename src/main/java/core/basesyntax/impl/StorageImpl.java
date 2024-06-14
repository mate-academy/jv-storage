package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        boolean isReplaced = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                isReplaced = true;
                break;
            }
        }
        if (!isReplaced) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        V getValue = null;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                getValue = values[i];
            }
        }
        return getValue;
    }

    @Override
    public int size() {
        return size;
    }
}
