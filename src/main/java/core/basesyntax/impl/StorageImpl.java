package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private static final int NUMBER_OF_ROWS = 2;
    private static final int INDEX_OF_KEY = 0;
    private static final int INDEX_OF_VALUE = 1;
    private final Object[][] elements = new Object[MAX_NUMBER_OF_ELEMENTS][NUMBER_OF_ROWS];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            elements[size][INDEX_OF_KEY] = key;
            elements[size++][INDEX_OF_VALUE] = value;
        } else {
            elements[index][INDEX_OF_VALUE] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) elements[index][INDEX_OF_VALUE];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, elements[i][INDEX_OF_KEY])) {
                return i;
            }
        }
        return -1;
    }
}
