package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int ITEM_FIELDS = 2;
    private Object[][] items = new Object[MAX_ITEMS_NUMBER][ITEM_FIELDS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyEquals(key, (K) items[i][0])) {
                items[i][1] = value;
                return;
            }
        }
        items[size][0] = key;
        items[size][1] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < items.length; i++) {
            if (isKeyEquals(key, (K) items[i][0])) {
                return (V) items[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyEquals(K firstKey, K secondKey) {
        return firstKey == null ? secondKey == null : firstKey.equals(secondKey);
    }
}
