package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object [] [] massiv = new Object[5][2];
    private int count;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (massiv[i][0].equals(key)) {
                massiv[i] = new Object[]{key, value};
                return;
            }
        }
        massiv[count] = new Object[]{key, value};
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (massiv[i][0] == null || massiv[i][0].equals(key)) {
                return (V) massiv[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (Object [] mass : massiv) {
            System.out.println(Arrays.toString(mass));
        }
        return count;
    }
}
