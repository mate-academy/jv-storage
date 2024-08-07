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
    public void put(K key, V value) {
        Node<K, V> node;
        if (size + 1 > DEFAULT_SIZE_OF_ARRAY) {
            System.out.println("The storage is full");
            return;
        }
        int index = isKeyPresent(key);
        if (index != -1) {
            table[index].setValue(value);
            return;
        }
        node = new Node<>(key, value);
        table[size] = node;
        size++;
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = isKeyPresent(key);
        if (index != -1) {
            result = table[index].getValue();
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public int isKeyPresent(K key) {
        int index;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey() == key || table[i].getKey() != null
                    && table[i].getKey().equals(key)) {
                index = i;
                return index;
            }
        }
        return -1;
    }
}


