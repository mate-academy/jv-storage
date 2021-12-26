package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int size;
    private final int max = 10;
    private K [] keys = (K[]) new Object[max];
    private V [] values = (V[]) new Object[max];

    @Override
    public void put(K key, V value) {

        if (size > max) {
            throw new RuntimeException("Arrays are full");
        }

        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                keys[i] = key;
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
        for (int i = 0; i < size; i++) {
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
