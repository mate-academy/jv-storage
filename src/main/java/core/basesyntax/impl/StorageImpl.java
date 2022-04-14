package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private static final int SIZE_OF_KEY_VALUE_PAIR = 2;
    private Object[][] storage;
    private int index;

    public StorageImpl() {
        storage = new Object[MAX_SIZE_STORAGE][SIZE_OF_KEY_VALUE_PAIR];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(storage[i][0], key)) {
                storage[i][1] = value;
                return;
            }
        }
        storage[index][0] = key;
        storage[index][1] = value;
        index++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(storage[i][0], key)) {
                return (V) storage[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
