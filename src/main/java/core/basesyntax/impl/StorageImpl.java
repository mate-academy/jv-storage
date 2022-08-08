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
                items[i].value = value;
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
    }
}
