package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Entry<K, V>[] entries = new Entry[MAX_ITEMS_NUMBER];
    private int size;

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                if (entries[i].key != null
                        && entries[i].key.equals(key)) {
                    return i;
                } else if (entries[i].key == null
                        && key == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (indexOfKey(key) != -1) {
            entries[indexOfKey(key)].value = value;
            return;
        }
        
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                entries[i] = new Entry<>(key, value);
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (indexOfKey(key) != -1) {
            return entries[indexOfKey(key)].value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
