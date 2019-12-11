package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CELLS_LENGTH = 10;
    private Cell[] cell = new Cell[CELLS_LENGTH];
    private int freeCell = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= freeCell; i++) {
            if (value != null) {
                if (freeCell == 0) {
                    cell[i] = new Cell<>(key, value);
                    freeCell++;
                    break;
                }
                if (freeCell < CELLS_LENGTH && i == freeCell) {
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
}
