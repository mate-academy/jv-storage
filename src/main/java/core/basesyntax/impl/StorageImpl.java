package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE_OF_ARRAY = 10;
    private int size;
    private Node<K, V>[] table;

    public StorageImpl() {
        table = new Node[DEFAULT_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) throws FullStorageException {
        if (size + 1 > DEFAULT_SIZE_OF_ARRAY) {
            throw new FullStorageException("The storage is full");
        }
        Node<K, V> entity;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey() == key || table[i].getKey() != null
                    && table[i].getKey().equals(key)) {
                table[i].setValue(value);
                return;
            }
        }
        entity = new Node<>(key, value);
        table[size] = entity;
        size++;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey() == key || table[i].getKey() != null
                    && table[i].getKey().equals(key)) {
                result = table[i].getValue();
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}


