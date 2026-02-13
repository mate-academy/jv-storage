package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;
    private int size = 0;
    private final K [] keys;
    private final V [] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
    }

    private int findIndexOf(K key) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (findIndexOf(key) == i) {
                keys[i] = key;
                values[i] = value;
                size--;
                break;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndexOf(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
