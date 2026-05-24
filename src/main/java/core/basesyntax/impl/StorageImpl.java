package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K [] key;
    private V [] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_CAPACITY];
        this.value = (V[]) new Object[MAX_CAPACITY];
        this.size = 0;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? this.key[i] == null : key.equals(this.key[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            this.value[index] = value;
            return;
        }
        if (size < MAX_CAPACITY) {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        } else {
            System.out.println("Array is full");
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index != -1 ? this.value[index] : null;
    }

    @Override
    public int size() {
        return size;
    }
}
