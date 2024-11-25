package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K[] keyBox;
    private V[] valueBox;
    private int counter;

    public StorageImpl() {
        keyBox = (K[]) new Object[MAX_VALUE];
        valueBox = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (keyBox[i] == key || keyBox[i] != null && keyBox[i].equals(key)) {
                valueBox[i] = value;
                return;
            }
        }
        keyBox[counter] = key;
        valueBox[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == keyBox[i] || key != null && key.equals(keyBox[i])) {
                return valueBox[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
