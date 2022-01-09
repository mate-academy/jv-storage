package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int maxItemsNumber = 10;
    private static Object[] keys = new Object[maxItemsNumber];
    private static Object[] values = new Object[maxItemsNumber];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size > maxItemsNumber) {
            System.out.println("the storage has run out of space ):");
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
