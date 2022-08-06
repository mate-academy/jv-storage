package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private StorageNode[] items;
    private int size;

    public StorageImpl() {
        items = new StorageNode[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (items[i].key != null && items[i].key.equals(key) || items[i].key == key) {
                items[i].setValue(value);
                return;
            }
        }

        items[size++] = new StorageNode(key, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (items[i].key != null && items[i].key.equals(key) || items[i].key == key) {
                return (V) items[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static class StorageNode {
        private Object key;
        private Object value;

        public StorageNode(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
