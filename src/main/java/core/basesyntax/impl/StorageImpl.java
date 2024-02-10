package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Object[][] keyValuePairs;
    private int size;

    public StorageImpl() {
        keyValuePairs = new Object[MAX_SIZE][2];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyValuePairs[i][KEY_INDEX])) {
                keyValuePairs[i][VALUE_INDEX] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keyValuePairs[size][KEY_INDEX] = key;
            keyValuePairs[size][VALUE_INDEX] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyValuePairs[i][KEY_INDEX])) {
                return (V) keyValuePairs[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
