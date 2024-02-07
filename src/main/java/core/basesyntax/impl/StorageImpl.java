package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair[] elements;
    private int size;

    public StorageImpl() {
        elements = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[size] = new Pair<>(key, value);
                size++;
                break;
            } else if (elements[i].key == key
                    || elements[i].key != null && elements[i].key.equals(key)) {
                elements[i].value = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                return null;
            } else if (key == elements[i].key || key != null && key.equals(elements[i].key)) {
                return (V) elements[i].value; //There is a compile error without cast
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K,V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
