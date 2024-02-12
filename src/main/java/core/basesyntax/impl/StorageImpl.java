package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[10];
        this.values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.isNull(keys[i]) && Objects.isNull(values[i])) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            } else if (!Objects.isNull(keys[i]) && Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            } else if (Objects.isNull(key) && Objects.isNull(keys[i])
                    && !Objects.isNull(values[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (!Objects.isNull(key) && Objects.equals(keys[i], key)) {
                return values[i];
            } else if (Objects.isNull(key) && Objects.isNull(keys[i])
                    && !Objects.isNull(values[i])) {
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
