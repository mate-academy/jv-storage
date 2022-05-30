package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final Object[] keys;
    private final Object[] values;
    private int numberOfElements;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENTS];
        values = new Object[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            if (values[i] == null) {
                values[i] = value;
                keys[i] = key;
                numberOfElements++;
                return;
            }
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
