package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private static final int NUMBER_OF_LINES = 2;
    private final Object[][] keys = new Object[MAX_NUMBER_OF_ELEMENTS][NUMBER_OF_LINES];
    private int size;

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i][0])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keys[size][0] = key;
            keys[size++][1] = value;
        } else {
            keys[index][1] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) keys[index][1];
    }

    @Override
    public int size() {
        return size;
    }
}
