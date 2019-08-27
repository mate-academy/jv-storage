package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Element first;

    public StorageImpl() {
        first = null;
    }

    @Override
    public void put(K key, V value) {
        Element element = new Element(key, value);
        element.next = first;
        first = element;
    }

    @Override
    public V get(K key) {
        Element<K, V> current = first;
        if (current == null) {
            return null;
        }
        while (current.key != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current.value;
    }

    public class Element<K, V> {
        private K key;
        private V value;
        private Element next;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
