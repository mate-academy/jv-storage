package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private static final int NUMBER_OF_LINES = 2;
    private static final int INDEX_OF_KEY = 0;
    private static final int INDEX_OF_VALUE = 1;
    private final Object[][] keys = new Object[NUMBER_OF_ELEMENTS][NUMBER_OF_LINES];
    private int size;

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i][INDEX_OF_KEY])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            keys[size][INDEX_OF_KEY] = key;
            keys[size++][INDEX_OF_VALUE] = value;
        } else {
            keys[index][INDEX_OF_VALUE] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) keys[index][INDEX_OF_VALUE];
    }

    @Override
    public int size() {
        return size;
    }
}
