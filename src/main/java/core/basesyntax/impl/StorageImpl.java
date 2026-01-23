package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;

    private Object[] keyS = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            // Używamy Objects.equals, aby bezpiecznie porównać klucze (też te null)
            if (key == keyS[i] || (key != null && key.equals(keyS[i]))){
                values[i] = value;
                return;
            }
        }
        keyS[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            // Używamy Objects.equals, aby bezpiecznie porównać klucze (też te null)
            if (key == keyS[i] || (key != null && key.equals(keyS[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
