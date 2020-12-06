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
            if (this.key != null && this.key.equals(key)) {
                this.items[i + 1] = value;
                break;
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
            if (this.key != null && this.key.equals(key)) {
                return (V) items[i + 1];
            } else if (this.key == null && key == null) {
                return (V) items[i + 1];
            }
        }
        System.out.println("ERROR: KEY NOT FOUND");
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        Storage<K, V> object = (Storage<K, V>) obj;
        if (this.key == object) {
            return true;
        }
        if (this.key == null || object == null) {
            return false;
        }
        if (this.key.getClass().equals(object.getClass())) {
            return (this.key.equals(object)
                    && this.key.hashCode() == object.hashCode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 71 * 31 + (this.key == null ? 0 : this.key.hashCode());
    }
}
