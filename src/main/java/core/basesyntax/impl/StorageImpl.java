package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM = 10;
    private final Object[][] storage;
    private int countFillItems = 0;

    public StorageImpl() {
        this.storage = new Object[MAX_ITEM][2];
    }

    @Override
    public void put(K key, V value) {
        int itemIndex = getItemIndex(key);
        if (itemIndex == -1) {
            int nextEmptyIndex = countFillItems;
            storage[nextEmptyIndex] = new Object[]{key, value};
            countFillItems++;
            return;
        }

        storage[itemIndex][1] = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int itemIndex = getItemIndex(key);
        if (itemIndex == -1) {
            return null;
        }

        return (V) storage[itemIndex][1];
    }

    @Override
    public int size() {
        return countFillItems;
    }

    private int getItemIndex(K key) {
        for (int i = 0; i < countFillItems; i++) {
            if ((key == null && storage[i][0] == null)
                    || (key != null && key.equals(storage[i][0]))) {
                return i;
            }
        }
        return -1;
    }

}
