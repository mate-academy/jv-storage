package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K key;
    private V value;
    private int sizeInt = 0;

    private ArrayRepresenting[] array = new ArrayRepresenting[MAX_ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        boolean trigger = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null
                    && ((key == null && this.array[i].keyJ == null)
                    || (this.array[i].keyJ != null && array[i].keyJ.equals(key)))) {
                array[i] = new ArrayRepresenting<>(key, value);
                trigger = false;
                break;
            }
        }
        if (trigger == true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = new ArrayRepresenting<>(key, value);
                    sizeInt++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].keyJ == null && key == null) {
                return (V) array[i].valueB;
            } else if (array[i] != null
                    && this.array[i].keyJ != null && array[i].keyJ.equals(key)) {
                return (V) array[i].valueB;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeInt;
    }

}


