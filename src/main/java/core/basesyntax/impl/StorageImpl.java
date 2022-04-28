package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private boolean firstNullNumber = true;
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        boolean j = true;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                j = false;
                if (firstNullNumber && key == null) {
                    size++;
                    firstNullNumber = false;
                }
                break;
            }
        }
        if (j) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
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
        return size;
    }
}
