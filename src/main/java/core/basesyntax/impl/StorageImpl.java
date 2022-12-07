package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Element[] elements;
    private int size = 0;

    {
        elements = new Element[10];
    }

    @Override
    public void put(K key, V value) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (elements[i].getKey() == key
                        || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                    elements[i].setValue(value);
                    return;
                }
            }
        }
        Element element = new Element(key, value);
        elements[size] = element;
        size++;
    }

    @Override
    public V get(K key) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (elements[i].getKey() == key
                        || elements[i].getKey() != null && elements[i].getKey().equals(key)) {
                    return (V) elements[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
