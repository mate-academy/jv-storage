package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private Element<K, V>[] elements;
    private int size;

    public StorageImpl() {
        elements = new Element[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == elements[i].getKey() || (key != null && key.equals(elements[i].getKey()))) {
                elements[i].setValue(value);
                return;
            }
        }
        elements[size] = new Element<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == elements[i].getKey() || (key != null && key.equals(elements[i].getKey()))) {
                return elements[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
