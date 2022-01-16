package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys = new Object[MAX_ITEMS_NUMBER];
    private Object[] values = new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((keys[i] == null && values[i] == null)
                    || (keys[i] == key) || Objects.equals(key, keys[i])) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (values[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
