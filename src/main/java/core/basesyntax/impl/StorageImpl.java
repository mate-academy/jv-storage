package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_ITEMS = 10;

    private int size;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH_ITEMS];
        values = new Object[MAX_LENGTH_ITEMS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) { // оба null → значит это тот же ключ
                values[i] = value;
                return;
            }
            if (keys[i] != null && keys[i].equals(key)) { // обычное сравнение
                values[i] = value;
                return;
            }
        }

        if (size >= MAX_LENGTH_ITEMS) {
            throw new IllegalStateException("Storage is full");
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return (V) values[i];
            }
            if (keys[i] != null && keys[i].equals(key)) {
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
