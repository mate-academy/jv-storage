package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_OF_STORAGE = 10;
    private StorageCell<K, V>[] cell;
    private int firstEmptyCell;

    public StorageImpl() {
        cell = new StorageCell[10];
        firstEmptyCell = 0;
    }

    @Override
    public void put(K key, V value) {
        if (!changeValueIfKeyExist(key, value)) {
            cell[firstEmptyCell] = new StorageCell<>();
            cell[firstEmptyCell].setKey(key);
            cell[firstEmptyCell].setValue(value);
            firstEmptyCell++;
        }
    }

    @Override
    public V get(K key) {
        for (StorageCell<K, V> tempCell : cell) {
            if (tempCell == null) {
                return null;
            }
            if (tempCell.getKey() == null ? key == null : tempCell.getKey().equals(key)) {
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
            if (tempCell.getKey() == null ? key == null : tempCell.getKey().equals(key)) {
                tempCell.setValue(value);
                return true;
            }
        }
        return false;
    }
}
