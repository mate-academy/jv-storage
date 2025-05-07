package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] value;
    private int size;

    public StorageImpl() {
        value = (V[]) new Object[MAX_ITEMS_NUMBER];
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    }

    public void setKey(K[] key) {
        keys = key;
    }

    public void setValue(V[] value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_ITEMS_NUMBER) {
            throw new IndexOutOfBoundsException("Storage reached it's max capacity");
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                this.value[i] = value;
                return;
            }
        }
        keys[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o.getClass().equals(StorageImpl.class)) {
            StorageImpl<K, V> storage = (StorageImpl<K, V>) o;
            return keys == storage.keys
                    || (keys != null && keys.equals(storage.keys))
                    && value == storage.value
                    || (value != null && value.equals(storage.value));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 13;
        return result * 17 + ((keys != null) ? keys.hashCode() : 0)
                + ((value != null) ? value.hashCode() : 0);
    }
}
