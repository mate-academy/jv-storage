package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM = 10;
    private final Object[][] storage;

    public StorageImpl() {
        this.storage = new Object[MAX_ITEM][];
    }

    @Override
    public void put(K key, V value) {
        int itemIndex = getItemIndex(key);
        if (itemIndex == -1) {
            int nextEmptyIndex = size();
            storage[nextEmptyIndex] = new Object[]{key, value};
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
        int countItem = 0;
        for (Object o : storage) {
            if (o != null) {
                countItem++;
            }
        }
        return countItem;
    }

    private int getItemIndex(K key) {
        for (int i = 0; i < MAX_ITEM; i++) {
            if (storage[i] != null
                    && ((key == null && storage[i][0] == null)
                    || (key != null && key.equals(storage[i][0])))) {
                return i;
            }
        }
        return -1;
    }

}
