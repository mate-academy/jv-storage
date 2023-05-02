package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ARRAY_LENGTH = 10;
    public static final int START_INDEX = 0;
    private final K[] keys = (K[]) new Object[MAX_ARRAY_LENGTH];
    private final V[] values = (V[]) new Object[MAX_ARRAY_LENGTH];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = indexOfProperCell(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        return (V) lookingForKeyValue(key);
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfProperCell(K key) {
        for (int i = START_INDEX; i < size; i++) {
            if ((key == keys[i]) || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private Object lookingForKeyValue(K key) {
        return indexOfProperCell(key) == -1 ? null
                : values[indexOfProperCell(key)];
    }

}
