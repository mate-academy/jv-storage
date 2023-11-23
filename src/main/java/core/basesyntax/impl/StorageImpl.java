package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Entry<K, V>[] data;

    private int size;

    public StorageImpl() {
        data = new Entry[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKey(key);
        if (index == -1) {
            data[size++] = new Entry<>(key, value);
        } else {
            data[index] = new Entry<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = findKey(key);
        if (index == -1) {
            return null;
        } else {
            return data[index].value();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private record Entry<K, V>(K key, V value) {
    }

    private int findKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == data[i].key() || (key != null && key.equals(data[i].key()))) {
                return i;
            }
        }
        return -1;
    }
}
