package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int itemsSize;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        itemsSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((values[i] != null && key == null && keys[i] == null)
                    || key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            values[i] = value;
            itemsSize++;
            return;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if ((key == null && keys[i] == null && values[i] != null)
                    || key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return itemsSize;
    }
}
