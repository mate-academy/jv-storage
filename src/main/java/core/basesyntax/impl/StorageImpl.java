package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int elementQuantity = 0;

    public StorageImpl() {
        this.keys = new Object[SIZE];
        this.values = new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = -1;
        for (int i = 0; i < elementQuantity; i++) {
            if (Objects.equals(keys[i], key)) {
                index = i;
                values[index] = value;
                break;
            }
        }
        if (index == -1) {
            values[elementQuantity] = value;
            keys[elementQuantity] = key;
            elementQuantity++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementQuantity; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementQuantity;
    }
}
