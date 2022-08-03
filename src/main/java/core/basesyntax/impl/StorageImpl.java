package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private StorageNode[] items;
    private int index;
    private boolean alreadyExists;

    public StorageImpl() {
        items = new StorageNode[MAX_ITEMS_NUMBER];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (StorageNode item : items) {
            if (item != null) {
                if (key != null) {
                    if (item.getKey() != null && item.getKey().equals(key)) {
                        alreadyExists = true;
                        item.setValue(value);
                    }
                } else {
                    if (item.getKey() == null) {
                        alreadyExists = true;
                        item.setValue(value);
                    }
                }
            }
        }

        if (!alreadyExists) {
            items[index] = new StorageNode(key, value);
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (StorageNode item : items) {
            if (item != null) {
                if (key != null) {
                    if (item.getKey() != null && item.getKey().equals(key)) {
                        return (V) item.getValue();
                    }
                } else {
                    if (item.getKey() == null) {
                        return (V) item.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
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
