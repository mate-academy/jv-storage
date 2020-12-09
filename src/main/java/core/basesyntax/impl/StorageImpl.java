package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER_WITH_KEYS = 20;
    private Object[] items;
    private int counter = 0;

    public StorageImpl() {
        items = new Object[MAX_ITEMS_NUMBER_WITH_KEYS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < items.length; i += 2) {
            K internalKey = (K) items[i];
            if (internalKey != null && internalKey.equals(key)) {
                this.items[i + 1] = value;
                return;
            }
        }
        items[counter] = key;
        items[counter + 1] = value;
        counter += 2;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i += 2) {
            K internalKey = (K) items[i];
            if ((internalKey == null && key == null)
                    || (internalKey != null && internalKey.equals(key))) {
                return (V) items[i + 1];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != getClass()) {
            return false;
        }
        K object = (K) obj;
        return this.equals(object);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Object item : items) {
            hash += 71 * 31 + (item == null ? 0 : item.hashCode());
        }
        return hash;
    }
}
