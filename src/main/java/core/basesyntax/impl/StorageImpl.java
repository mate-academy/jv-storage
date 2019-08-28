package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private Object[][] storage = new Object[2][16];
    private int size = this.getIndex();

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[0][i] == key || storage[0][i].equals(key)) {
                storage[1][i] = value;
                break;
            }
        }
        storage[0][size] = key;
        storage[1][size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <size; i++) {
            if (storage[0][i] == key || storage[0][i].equals(key)) {
                return (V) storage[1][i];
            }
        }
        return null;
    }

    private int getIndex() {
        if (size < storage[1].length) {
            return size;
        }
        storage[0] = Arrays.copyOf(storage[0], storage[0].length * 2);
        storage[1] = Arrays.copyOf(storage[1], storage[1].length * 2);
        return storage[1].length / 2;
    }
}
