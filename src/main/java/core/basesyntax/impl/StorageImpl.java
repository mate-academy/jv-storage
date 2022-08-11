package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final String EMPTY_KEY = "empty";
    private final Object[] keys = new Object[10];
    private final Object[] values = new Object[10];

    {
        Arrays.fill(keys,EMPTY_KEY);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size ; i++) {
            if ((key  == keys[i]) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
                keys[size] = key;
                values[size] = value;
                size++;
            }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null) {
                if (key == keys[i]) {
                    return (V)values[i];
                }
                continue;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(EMPTY_KEY)) {
                return i;
            }
        }
        return keys.length;
    }
}
