package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private static final int INITIAL_SIZE = 0;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.values = (V[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.size = INITIAL_SIZE;
    }

    @Override
    public void put(K key, V value) {
        int i = findIndexByKey(key);
        if (i != -1) {
            values[i] = value;
        } else if (size < MAX_NUMBERS_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public V get(K key) {
        int i = findIndexByKey(key);
        return i != -1 ? values[i] : null;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
