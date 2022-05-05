package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[5];
    private final V[] values = (V[]) new Object[5];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        this.keys[count] = key;
        this.values[count] = value;
        count++;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || Objects.equals(keys[i], key)) {
                values[i] = value;
                keys[count] = null;
                values[count] = null;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || Objects.equals(keys[i], key)) {
                count--;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
