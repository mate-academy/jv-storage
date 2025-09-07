package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_SIZE = 10;
    private final Entry<K, V>[] entries;

    public StorageImpl() {
        this.entries = (Entry<K, V>[]) new Entry[10];
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].getKey() != null
                    && entries[i].getKey().equals(key)) {
                return i;
            }
            if (entries[i] != null && entries[i].getKey() == null && key == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index >= 0) {
            if (entries[index] == null) {
                entries[index] = new Entry<>(key, value);
            } else {
                entries[index].setValue(value);
            }
        } else {
            for (int i = 0; i < entries.length; i++) {
                if (entries[i] == null) {
                    entries[i] = new Entry<>(key, value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        if (index >= 0 && entries[index] != null) {
            return entries[index].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        int currentSize = 0;
        for (Entry<K,V> entry : entries) {
            if (entry != null) {
                currentSize = currentSize + 1;
            }
        }
        return currentSize;
    }
}
