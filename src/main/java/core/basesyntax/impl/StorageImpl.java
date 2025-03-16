package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final List<Element<K, V>> elementList = new ArrayList<>();

    public List<Element<K, V>> getElementList() {
        return elementList;
    }

    @Override
    public void put(K key, V value) {
        Element<K, V> element = findElement(key);
        if (element != null) {
            element.setValue(value);
        } else {
            elementList.add(new Element<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        Element<K, V> element = findElement(key);
        return element != null ? element.getValue() : null;
    }

    /**
     * Help method to find element
     */
    private Element<K, V> findElement(K key) {
        for (Element<K, V> element : elementList) {
            if ((key == null && element.getKey() == null)
                    || (element.getKey() != null && element.getKey().equals(key))) {
                return element;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementList.size();
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
