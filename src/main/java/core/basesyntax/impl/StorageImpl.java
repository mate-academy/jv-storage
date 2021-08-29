package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        value = (V[]) new Object[MAX_ITEMS_NUMBER];
        key = (K[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;

    }

    public K[] getKey() {
        return key;
    }

    public void setKey(K[] key) {
        this.key = key;
    }

    public V[] getValue() {
        return value;
    }

    public void setValue(V[] value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key || this. key[i] != null && this.key[i].equals(key)) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
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
            return key == storage.key
                    || (key != null && key.equals(storage.key))
                    && value == storage.value
                    || (value != null && value.equals(storage.value));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 13;
        return result * 17 + ((key != null) ? key.hashCode() : 0)
                + ((value != null) ? value.hashCode() : 0);
    }
}
