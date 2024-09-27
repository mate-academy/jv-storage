package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private int size;
    private Element<K, V>[] elements;

    public StorageImpl() {
        elements = new Element[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index >= 0) {
            elements[index] = new Element(key, value);
        } else {
            elements[size++] = new Element(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index >= 0 ? elements[index].value : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < this.size; i++) {
            if ((elements[i].key != null && elements[i].key.equals(key))
                    || elements[i].key == key) {
                return i;
            }
        }
        return -1;
    }

    private class Element<K, V> {
        private K key;
        private V value;

        private Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
