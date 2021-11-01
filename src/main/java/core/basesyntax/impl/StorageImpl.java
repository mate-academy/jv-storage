package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int numberOfKeys = 0;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (numberOfKeys == MAX_ITEMS_NUMBER) {
            return;
        }
        numberOfKeys++;
        keys[numberOfKeys - 1] = key;
        values[numberOfKeys - 1] = value;
        for (int i = 0; i < numberOfKeys; i++) {
            if ((keys[i] == keys[i + 1]) || (keys[i] != null && keys[i].equals(keys[i + 1]))) {
                values[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Object o : keys) {
            if ((o == null && key == null) || (o != null && o.equals(key))) {
                return (V) values[Arrays.asList(keys).indexOf(key)];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < numberOfKeys - 1; i++) {
            if ((keys[i] == keys[i + 1]) || (keys[i] != null && keys[i].equals(keys[i + 1]))) {
                numberOfKeys--;
            }
        }
        return numberOfKeys;
    }
}
