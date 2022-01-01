package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private final Object[] array = new Object[CAPACITY];

    private class Element {
        private final K key;
        private V value;

        Element(K key, V value) {
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

    @Override
    public void put(K key, V value) {
        Element element = getElement(key);
        if (element == null) {
            if (size >= CAPACITY) {
                throw new RuntimeException("Couldn't add new elements to storage");
            }
            element = new Element(key, value);
            array[size] = element;
            size++;
            return;
        }
        element.setValue(value);
    }

    @Override
    public V get(K key) {
        Element element = getElement(key);
        if (element != null) {
            return element.getValue();
        }
        return null;
    }

    private Element getElement(K key) {
        for (int i = 0; i < size; i++) {
            Object bufObj = array[i];
            if (bufObj == null) {
                continue;
            }
            Element element = (Element) bufObj;
            if (keyEquals(element, key)) {
                return element;
            }
        }
        return null;
    }

    private boolean keyEquals(Element element, K key) {
        K thisKey = element.getKey();
        return thisKey == null ? key == null : thisKey.equals(key);
    }

    @Override
    public int size() {
        return size;
    }
}
