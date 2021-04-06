package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int MIN_ITEMS_NUMBER = 0;
    private StorageImpl[] list;
    private int counter;
    private K key;
    private V value;

    public StorageImpl() {
        list = new StorageImpl[MAX_ITEMS_NUMBER];
        counter = MIN_ITEMS_NUMBER;
    }

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter;i++) {
            if (list[i].key == null ? list[i].key == key
                    : list[i].key.equals(key)) {
                list[i] = new StorageImpl<>(key, value);
                return;
            }
        }
        list[counter] = new StorageImpl<>(key, value);
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (list[i].key == null ? list[i].key == key
                    : list[i].key.equals(key)) {
                return (V) list[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
