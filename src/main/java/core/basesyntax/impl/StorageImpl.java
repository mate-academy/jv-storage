package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE_ARRAY];
        this.values = (V[]) new Object[SIZE_ARRAY];
        size = 0;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && this.keys[i] == null)
                    || (this.keys[i] != null && this.keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);

        if (index != -1) {
            // ключ уже есть → обновляем
            values[index] = value;
            return;
        }

        // ключа нет → добавляем
        if (size < keys.length) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("The storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
