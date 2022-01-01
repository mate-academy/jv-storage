package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int CAPACITY = 10;
    private int size = 0;
    private Object[] array = new Object[CAPACITY]; //

    private class Element<K1,V1> {
        private K1 key;
        private V1 value;
        Element(K1 key, V1 value) {
            this.key = key;
            this.value = value;
        }

        public K1 getKey() {
            return key;
        }

        public V1 getValue() {
            return value;
        }

        public void setValue(V1 value) {
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        Element <K,V> element = getElement(key);
        if (element == null) {
            element = new Element<>(key, value);
            array[size] = element;
            size++;
            return;
        }
        element.setValue(value);
    }

    @Override
    public V get(K key) {
        Element <K,V> element = getElement(key);
        if (element != null) {
            return element.getValue();
        }
        return null;
    }

    private Element<K,V> getElement(K key) {
        for (int i = 0; i < size; i++) {
            Object bufObj = array[i];
            if (bufObj == null) {
                continue;
            }
            Element<K,V> element = (Element<K,V>) bufObj;
            if (Objects.equals(element.getKey(), key)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
