package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int numberOfElement;
    private Object [] values;
    private Object [] keys;

    {
        values = new Object[MAX_ITEMS_NUMBER];
        keys = new Object[MAX_ITEMS_NUMBER];
        numberOfElement = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean alreadyInArray = false;
        for (int i = 0; i < numberOfElement; i++) {
            if (Objects.equals(keys[i],key)) {
                values[i] = value;
                alreadyInArray = true;
            }
        }
        if (!alreadyInArray) {
            keys[numberOfElement] = key;
            values[numberOfElement] = value;
            numberOfElement++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }

        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object value : values) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }
}
