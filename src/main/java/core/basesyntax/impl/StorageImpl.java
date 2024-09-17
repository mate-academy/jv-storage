package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int size;
    private final Node<K, V>[] storageItems;

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
            } else if (keyCondition(key, i)) {
                storageItems[i] = node;
                break;
            }
        }
    }

    private boolean keyCondition(K key, int keyIndex) {
        return (key == storageItems[keyIndex].key || (storageItems[keyIndex].key != null
                && storageItems[keyIndex].key.equals(key)));
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyCondition(key, i)) {
                return storageItems[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
