package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private int size;
    private Cell[] cells;

    public StorageImpl() {
        this.cells = new Cell[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndexByKey(key);
        if (keyIndex < 0) {
            cells[size] = new Cell(key, value);
            size++;
        } else {
            cells[keyIndex].setValue(value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndexByKey(key);
        if (keyIndex >= 0) {
            return (V) cells[keyIndex].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (cells[i].key == key
                    || cells[i].key != null && cells[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    static class Cell<K,V> {
        private K key;
        private V value;

        Cell(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
}
