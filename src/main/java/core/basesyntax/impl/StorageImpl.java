package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_ARRAY_LENGTH = 10;
    private Box<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Box[INITIAL_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        Box<K, V> box = getBoxByKey(key);
        if (box != null) {
            box.setValue(value);
            return;
        }
        box = new Box<>(key, value);
        if (size == INITIAL_ARRAY_LENGTH) {
            throw new IndexOutOfBoundsException("Unable to put element, storage is full");
        }
        storage[size++] = box;
    }

    @Override
    public V get(K key) {
        Box<K, V> box = getBoxByKey(key);
        return box == null ? null : box.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private Box<K, V> getBoxByKey(K key) {
        for (int i = 0; i < size; i++) {
            Box<K, V> box = storage[i];
            if (box.getKey() == key || box.getKey() != null && box.getKey().equals(key)) {
                return box;
            }
        }
        return null;
    }

}
