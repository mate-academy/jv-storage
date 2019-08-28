package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int size = 0;
    private Entry [] entries = new Entry[15];

    @Override
    public void put(K key, V value) {
        if (size > entries.length) {
            entries = Arrays.copyOfRange(entries, 0, entries.length * 2);
        }
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey() == key || entries[i].getKey().equals(key)) {
                entries[i] = new Entry(key, value);
                break;
            }
        }
        entries[size++] = new Entry(key, value);
    }


    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey() == key || entries[i].getKey().equals(key)) {
                return (V) entries[i].getValue();
            }
        }
        return null;
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
}

