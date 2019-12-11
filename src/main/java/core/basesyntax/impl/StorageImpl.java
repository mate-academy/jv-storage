package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CELLSLENGTH = 10;
    private Cell[] cell = new Cell[CELLSLENGTH];
    //private Object[] value = new Object[ARRAYLENGTH];
    private int freeCell = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= freeCell; i++) {
            if (key != null && value != null) {
                if (freeCell == 0) {
                    cell[i] = new Cell<>(key, value);
                    freeCell++;
                    break;
                }
                if (freeCell < CELLSLENGTH && i == freeCell) {
                    cell[i] = new Cell<>(key, value);
                    freeCell++;
                    break;
                }
                K temp = (K) cell[i].getKey();
                if (freeCell < CELLSLENGTH && temp.equals(key)) {
                    cell[i].setValue(value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (key != null) {
            for (int i = 0; i < freeCell; i++) {
                K temp = (K) cell[i].getKey();
                if (temp.equals(key)) {
                    V temp1 = (V) cell[i].getValue();
                    return (V) cell[i].getValue();
                }
            }
        }
        return null;
    }
}
