package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ELEMENTS_LENGTH = 10;
    public static final int NOT_FOUND_ELEM_IDX = -1;

    private final Integer[] keys = new Integer[MAX_ELEMENTS_LENGTH];
    private V[] values;

    @Override
    public void put(K key, V value) {
        if (this.values == null) {
            this.initializeValuesArray(value.getClass());
        }

        int existingKeyIndex = this.getKeyIndex(key);

        if (existingKeyIndex != NOT_FOUND_ELEM_IDX) {
            this.values[existingKeyIndex] = value;
        } else {
            int freeIndex = this.size();

            this.keys[freeIndex] = key != null ? key.hashCode() : 0;
            this.values[freeIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = this.getKeyIndex(key);

        if (index == NOT_FOUND_ELEM_IDX) {
            return null;
        }

        return this.values[index];
    }

    @Override
    public int size() {
        return Arrays
                .stream(this.keys)
                .filter(Objects::nonNull)
                .toArray()
                .length;
    }

    @SuppressWarnings("unchecked")
    private void initializeValuesArray(Class<?> valuesClass) {
        this.values = (V[]) Array.newInstance(
                valuesClass,
                MAX_ELEMENTS_LENGTH
        );
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < this.keys.length; i += 1) {
            if (keys[i] != null
                    &&  keys[i] == (key != null ? key.hashCode() : 0)
            ) {
                return i;
            }
        }

        return NOT_FOUND_ELEM_IDX;
    }
}
