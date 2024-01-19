package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_ITEMS_NUMBER];
        this.values = new Object[MAX_ITEMS_NUMBER];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_ITEMS_NUMBER) {
            for (int i = 0; i < size; i++) {
                if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("The storage is full, it is impossible to make a new entry");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        // Вернуть null, если ключ не найден
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
