package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private static final int NOT_EXISTING_INDEX = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAXIMUM_NUMBER_OF_ELEMENTS) {
            throw new IndexOutOfBoundsException("maximum number of elements in our Storage is "
                    + MAXIMUM_NUMBER_OF_ELEMENTS);
        }
        int index = getIndexByKey(key);
        if (index == NOT_EXISTING_INDEX) { // add element
            keys[size] = key;
            values[size] = value;
            size++;
        } else { // update element
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index == NOT_EXISTING_INDEX) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NOT_EXISTING_INDEX;
    }
}
