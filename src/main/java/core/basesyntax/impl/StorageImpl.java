package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size;
    private Container<K, V>[] container;

    public StorageImpl() {
        container = new Container[MAX_ELEMENTS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        Container<K, V> current = getCont(key);
        if (current != null) {
            current.parametervalue = value;
            return;
        }
        container[size] = new Container<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        Container<K, V> current = getCont(key);
        if (current != null) {
            return current.parametervalue;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Container<K, V> getCont(K key) {
        for (int i = 0; i < size; i++) {
            if ((container[i].parameterkey == null && key == null)
                    || (container[i].parameterkey != null
                    && container[i].parameterkey.equals(key))) {
                return container[i];
            }
        }
        return null;
    }

    private static class Container<K, V> {
        private K parameterkey;
        private V parametervalue;

        public Container(K key, V value) {
            parameterkey = key;
            parametervalue = value;
        }
    }
}
