package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int topElement;
    private final Object[][] elements;

    public StorageImpl() {
        elements = new Object[MAX_SIZE][2];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index == -1) {
            if (topElement < MAX_SIZE) {
                elements[topElement][0] = key;
                elements[topElement][1] = value;
                topElement++;
            }
        } else {
            elements[index][1] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return (V) elements[index][1];
        }
        return null;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < topElement; i++) {
            if (key == elements[i][0] || key != null && key.equals(elements[i][0])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return topElement;
    }
}
