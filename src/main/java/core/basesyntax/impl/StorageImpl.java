package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                values[i] = value; // Заменяем значение для null ключа
                return;
            } else if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value; // Заменяем значение
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return values[i]; // Возвращаем значение для null ключа
            } else if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null; // Если ключ не найден
    }

    @Override
    public int size() {
        return size;
    }
}
