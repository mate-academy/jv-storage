package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static Object SIZE_OBJECT;
    private static final int LENGTH = 10;
    private Object[] keys = new Object[LENGTH];
    private Object[] values = new Object[LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((values[i] == null)
                    || (key == keys[i] && values[i] != null)
                    || (key != null && key.equals(keys[i]))) {
                keys[i] = key;
                values[i] = value;
                SIZE_OBJECT = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        try {
            return (V) values[Arrays.asList(keys).indexOf(key)];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public int size() {
        return Arrays.asList(values).indexOf(SIZE_OBJECT) + 1;
    }
}
