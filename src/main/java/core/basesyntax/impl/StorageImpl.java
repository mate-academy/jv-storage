package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size = 1;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key) || (key == null && keys[i] == null)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key) || (key == null && keys[i] == null)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
