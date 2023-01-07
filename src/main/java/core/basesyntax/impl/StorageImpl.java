package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private Node<K, V>[] storageItems;

    public StorageImpl() {
        this.storageItems = new Node[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        for (int i = 0; i < storageItems.length; i++) {
            if (storageItems[i] == null) {
                storageItems[i] = node;
                size++;
                break;
            } else if (key == storageItems[i].key || (storageItems[i].key != null
                    && storageItems[i].key.equals(key))) {
                storageItems[i] = node;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storageItems[i].key
                    || (storageItems[i].key != null && storageItems[i].key.equals(key))) {
                return storageItems[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
