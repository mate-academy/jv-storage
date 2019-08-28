package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private Object[][] storage = new Object[2][16];

    @Override
    public void put(K key, V value) {
        int index = this.getIndex();
        for (int i = 0; i < index; i++) {
            if (storage[0][i] == key || storage[0][i].equals(key)) {
                storage[1][i] = value;
                break;
            }
        }
        storage[0][index] = key;
        storage[1][index] = value;
    }
        /*if (storage == null)  {
            storage = new Object[][] {{key}, {value}};
        } else {
            for (int i = 0; i < storage[0].length; i++) {
                if (storage[0][i] == key || storage[0][i].equals(key)) {
                    storage[1][i] = value;
                    break;
                }
            }
            storage[0] = Arrays.copyOf(storage[0], storage[0].length + 1);
            storage[0][storage[0].length - 1] = key;
            storage[1] = Arrays.copyOf(storage[1], storage[1].length + 1);
            storage[1][storage[1].length - 1] = value;
        }
    }*/


    @Override
    public V get(K key) {
        for (int i = 0; i < this.getIndex(); i++) {
            if (storage[0][i] == key || storage[0][i].equals(key)) {
                return (V) storage[1][i];
            }
        }
        return null;
    }

    private int getIndex() {
        for (int i = 0; i < storage[1].length; i++) {
            if (storage[1][i] == null) {
                return i;
            }
        }
        storage[0] = Arrays.copyOf(storage[0], storage[0].length * 2);
        storage[1] = Arrays.copyOf(storage[1], storage[1].length * 2);
        return storage[1].length / 2;
    }
}

