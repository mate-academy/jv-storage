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
            } else if (key == storageItems[i].getKey() || (storageItems[i].getKey() != null
                    && storageItems[i].getKey().equals(key))) {
                storageItems[i] = node;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storageItems[i].getKey()
                    || (storageItems[i].getKey() != null && storageItems[i].getKey().equals(key))) {
                return (V) storageItems[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
