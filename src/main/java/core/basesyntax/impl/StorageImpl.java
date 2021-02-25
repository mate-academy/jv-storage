package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int count = 0;
    private Object[] keyElem = new Object[MAX_ITEMS_NUMBER];
    private Object[] valueElem = new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null && keyElem[i] == null || key != null && key.equals(keyElem[i])) {
                valueElem[i] = value;
                return;
            }
        }
        keyElem[count] = key;
        valueElem[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        int indexElem = 0;
        for (int i = 0; i < count; i++) {
            if (key == null && keyElem[i] == null || key != null && key.equals(keyElem[i])) {
                indexElem = i;
            }
        }
        return (V) valueElem[indexElem];
    }

    @Override
    public int size() {
        return count;
    }
}
