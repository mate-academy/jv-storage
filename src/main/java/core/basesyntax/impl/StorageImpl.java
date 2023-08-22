package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private int topElement = 0;
    private final Object[][] elements = new Object[MAX_SIZE][2];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < topElement; i++) {
            if (key == null) {
                if (elements[i][0] == null) {
                    elements[i][1] = value;
                    return;
                }
                continue;
            }
            if (key.equals(elements[i][0])) {
                elements[i][1] = value;
                return;
            }
        }
        elements[topElement][0] = key;
        elements[topElement][1] = value;
        topElement++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < topElement; i++) {
            if (key == null) {
                if (elements[i][0] == null) {
                    return (V) elements[i][1];
                }
                continue;
            }
            if (elements[i][0] == null) {
                continue;
            }
            if (elements[i][0].equals(key)) {
                return (V) elements[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return topElement;
    }
}
