package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int KEYS_AND_VALUES_SPACE = 2;
    private Object[][] data;
    private int size;

    public StorageImpl() {
        data = new Object[MAX_CAPACITY][KEYS_AND_VALUES_SPACE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i][0], key)) {
                data[i][1] = value;
                return;
            }
        }
        data[size][0] = key;
        data[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < size; j++) {
            if (Objects.equals(data[j][0], key)) {
                return (V) data[j][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
