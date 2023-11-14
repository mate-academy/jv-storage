package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] storageArray;
    private K key;
    private V value;
    private int size = 0;

    public StorageImpl() {
        this.storageArray = new Object[CAPACITY];
        this.size = 0;
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            StorageImpl<K, V> entry = (StorageImpl<K, V>) storageArray[i];
            if (key == null && entry.getKey() == null
                    || key != null && entry.getKey() == key
                    || entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        storageArray[size++] = new StorageImpl<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            StorageImpl<K, V> entry = (StorageImpl<K, V>) storageArray[i];
            if (entry.getKey() == key || entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<K, V> kvStorage = (StorageImpl<K, V>) obj;
        return (kvStorage.getKey() == key
                || (kvStorage.getKey() != null && kvStorage.getKey().equals(key))
                || kvStorage.getKey() == null & key == null)
                && (kvStorage.getValue() == value
                || (kvStorage.getValue() != null && kvStorage.getValue().equals(value)));
    }
}
