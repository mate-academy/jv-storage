package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CELLS_LENGTH = 10;
    private Cell[] cell = new Cell[CELLS_LENGTH];
    private int freeCell = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= freeCell && value != null; i++) {
            if (freeCell == 0 || (freeCell < CELLS_LENGTH && i == freeCell)) {
                cell[i] = new Cell<>(key, value);
                freeCell++;
                break;
            }
            if (cell[i].getKey() != null) {
                if (freeCell < CELLS_LENGTH && ((K) cell[i].getKey()).equals(key)) {
                    cell[i].setValue(value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < freeCell; i++) {
            if (cell[i].getKey() == key || ((K) cell[i].getKey()).equals(key)) {
                return (V) cell[i].getValue();
            }
        }
        return null;
    }

    private class Cell<K, V> {

        private K key;
        private V value;

        public Cell(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
