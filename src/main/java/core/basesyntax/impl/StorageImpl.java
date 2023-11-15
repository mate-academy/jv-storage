package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private StorageImpl[] storageArray;
    private K key;
    private V value;
    private int size;

    public StorageImpl() {
        this.storageArray = new StorageImpl[CAPACITY];
        this.size = 0;
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            StorageImpl<K, V> storageItem = storageArray[i];
            if ((key == null && storageItem.getKey() == null)
                    || (key != null && storageItem.getKey() == key)
                    || storageItem.getKey() != null && storageItem.getKey().equals(key)) {
                storageItem.setValue(value);
                return;
            }
        }
        storageArray[size++] = new StorageImpl<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            StorageImpl<K, V> storageItem = storageArray[i];
            if (storageItem.getKey() == key
                    || storageItem.getKey() != null && storageItem.getKey().equals(key)
                    || key == null && storageItem.getKey() == null) {
                return storageItem.getValue();
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
}

