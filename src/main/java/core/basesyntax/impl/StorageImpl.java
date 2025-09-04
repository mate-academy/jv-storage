package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOfKey(key);
        if (index != -1) {
            // ключ уже існує → оновлюємо значення
            values[index] = value;
            return;
        }
        // шукаємо вільне місце
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
        }
        // якщо сюди дійшло → місця немає, але за умовою максимум 10
    }

    @Override
    public V get(K key) {
        int index = indexOfKey(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (key == null && keys[i] == null && values[i] != null) {
                return i;
            }
            if (key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
