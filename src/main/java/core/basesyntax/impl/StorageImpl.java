package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAY_SIZE];
    private V[] values = (V[]) new Object[ARRAY_SIZE];
    private int index;
    private int size;
    private K key;

    @Override
    public void put(K key, V value) {
        if (size >= ARRAY_SIZE) {
            throw new RuntimeException("Size is full");
        }
        for (int i = 0; i < keys.length; i++) {
            if (this.key == null && key == null && i > 0) {
                values[i] = value;
                return;
            }
            if (Objects.equals(keys[i], key) && key != null) {
                values[i] = value;
                this.key = key;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
        size++;
        this.key = key;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
