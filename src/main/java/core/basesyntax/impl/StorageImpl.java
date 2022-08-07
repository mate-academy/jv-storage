package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBERS_OF_ELEMENTS = 10;
    private Object[] arrayOfKeys;
    private Object[] arrayOfValues;
    private int index = 0;

    public StorageImpl() {
        arrayOfKeys = new Object[MAXIMUM_NUMBERS_OF_ELEMENTS];
        arrayOfValues = new Object[MAXIMUM_NUMBERS_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            arrayOfKeys[index] = key;
            arrayOfValues[index] = value;
            index++;
        } else {
            arrayOfValues[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return getIndex(key) == -1 ? null : (V) arrayOfValues[getIndex(key)];
    }

    @Override
    public int size() {
        return index;
    }

    private int getIndex(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(arrayOfKeys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
