package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_LENGTH_ARRAY = 10;
    private static int itemCounter = 0;
    private K[] keys = (K[]) new Object[INITIAL_LENGTH_ARRAY];
    private V[] values = (V[]) new Object[INITIAL_LENGTH_ARRAY];

    @Override
    public void put(K key, V value) {
        if (isDuplicate(key)) {
            for (int i = 0; i < keys.length; i++) {
                if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                }
            }
        } else {
            keys[itemCounter] = key;
            values[itemCounter] = value;
            itemCounter++;
            K[] cloneKeys = Arrays.copyOf(keys, INITIAL_LENGTH_ARRAY + itemCounter);
            keys = cloneKeys;
            V[] cloneValues = Arrays.copyOf(values, INITIAL_LENGTH_ARRAY + itemCounter);
            values = cloneValues;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }

        }
        return null;
    }

    private boolean isDuplicate(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return true;
            }
        }
        return false;
    }
}
