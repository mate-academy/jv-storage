package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int size = 0;
    private Entry [] entryArr = new Entry[15];

    @Override
    public void put(K key, V value) {
        if (size > entryArr.length) {
            entryArr = Arrays.copyOfRange(entryArr, 0, entryArr.length * 2);
        }
        for (int i = 0; i < size; i++) {
            if (entryArr[i].getKey() == key || key == null) {
                entryArr[i] = new Entry(key, value);
                break;
            }
        }
        entryArr[size++] = new Entry(key, value);
    }


    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entryArr[i].getKey() == key || key == null) {
                return (V) entryArr[i].getValue();
            }
        }
        return null;
    }

    public class Entry<K, V> {
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

