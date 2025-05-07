package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private int size = 0;

    private final Object[] keysArray;
    private final Object[] valuesArray;

    public StorageImpl() {
        keysArray = new Object[MAX_ARRAY_SIZE];
        valuesArray = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int indexByKey = getIndexByKey(key);
        if (indexByKey != INDEX_NOT_FOUND) {
            valuesArray[indexByKey] = value;
        } else {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int indexByKey = getIndexByKey(key);
        if (indexByKey != INDEX_NOT_FOUND) {
            return (V) valuesArray[indexByKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keysArray[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
