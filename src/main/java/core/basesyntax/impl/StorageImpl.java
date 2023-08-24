package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ARRAY = 12;

    private Element<K, V>[] elements = new Element[MAX_NUMBER_OF_ARRAY];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int number = 0; number < size; number++) {
            if (elements[number].getKey() == key || key != null
                    && key.equals(elements[number].getKey())) {
                elements[number].setValue(value);
                return;
            }
        }
        elements[size] = new Element<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int number = 0; number < size; number++) {
            if (elements[number].getKey() == key || key != null
                    && key.equals(elements[number].getKey())) {
                return elements[number].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Element<K, V> {
        private final K key;
        private V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
