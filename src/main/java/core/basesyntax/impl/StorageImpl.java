package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private Pair[] array;
    private int size;

    public StorageImpl() {
        array = new Pair[SIZE_OF_ARRAY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == array[i].getKey() || key != null && key.equals(array[i].getKey())) {
                array[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        array[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == array[i].getKey() || key != null && key.equals(array[i].getKey())) {
                return (V) array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
