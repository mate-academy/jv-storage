package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER_WITH_KEYS = 20;
    private final Object[] items = new Object[MAX_ITEMS_NUMBER_WITH_KEYS];
    private int counter = 0;
    private K key;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < items.length; i += 2) {
            this.key = (K) items[i];
            if ((this.key == null && key == null)
                    || (this.key != null && this.key.equals(key))) {
                this.items[i + 1] = value;
                return;
            }
        }
        this.items[counter] = key;
        this.items[counter + 1] = value;
        counter += 2;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < items.length; i += 2) {
            this.key = (K) items[i];
            if ((this.key == null && key == null)
                    || (this.key != null && this.key.equals(key))) {
                return (V) items[i + 1];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.key == obj) {
            return true;
        }
        if (obj == null || this.key.getClass() != getClass()) {
            return false;
        }
        K object = (K) obj;
        return this.key.equals(object);
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
