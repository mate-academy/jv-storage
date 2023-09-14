package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int NOT_FOUND = -1;
    private int size = 0;
    private K[] keys = (K[]) new Object[MAX_CAPACITY];
    private V[] values = (V[]) new Object[MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        if (this.size > MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Storage is full!");
        }

        int indexOfFoundElement = getIndexIfContains(key);

        if (indexOfFoundElement != NOT_FOUND) {
            this.values[indexOfFoundElement] = value;
            return;
        }

        this.keys[size] = key;
        this.values[size] = value;
        this.size++;
    }

    @Override
    public V get(K key) {
        int indexOfFoundElement = getIndexIfContains(key);
        if (indexOfFoundElement == -1) {
            return null;
        }

        return values[getIndexIfContains(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexIfContains(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }

        return NOT_FOUND;
    }
}
