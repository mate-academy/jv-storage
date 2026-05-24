package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

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

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
