package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_OF_STORAGE = 10;
    private StorageCell<K, V>[] cell;
    private int currentEmptyCell;

    public StorageImpl() {
        cell = new StorageCell[LENGTH_OF_STORAGE];
        currentEmptyCell = 0;
    }

    @Override
    public void put(K key, V value) {
        if (!changeValueIfKeyExist(key, value)) {
            cell[currentEmptyCell] = new StorageCell<>();
            cell[currentEmptyCell].setKey(key);
            cell[currentEmptyCell].setValue(value);
            currentEmptyCell++;
        }
    }

    @Override
    public V get(K key) {
        for (StorageCell<K, V> tempCell : cell) {
            if (tempCell == null) {
                return null;
            }
            if (tempCell.getKey() == key || key != null && key.equals(tempCell.getKey())) {
                return tempCell.getValue();
            }
        }
        return null;
    }

    public boolean changeValueIfKeyExist(K key, V value) {
        for (StorageCell<K, V> tempCell : cell) {
            if (tempCell == null) {
                return false;
            }
            if (tempCell.getKey() == key || key != null && key.equals(tempCell.getKey())) {
                tempCell.setValue(value);
                return true;
            }
        }
        return false;
    }

    private class StorageCell<K, V> {
        private K key;
        private V value;

        public StorageCell() {
            this.key = (K) new Object();
            this.value = (V) new Object();
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
