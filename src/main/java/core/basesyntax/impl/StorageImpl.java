package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int indexOfElement = -1;

    public StorageImpl() {
        this.keys = new Object[MAX_ARRAY_NUMBER];
        this.values = new Object[MAX_ARRAY_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < indexOfElement + 1; i++) {
            K current = (K) this.keys[i];
            if (Objects.equals(key, current)) {
                values[i] = value;
                return;
            }
        }
        indexOfElement++;

        if (indexOfElement > MAX_ARRAY_NUMBER - 1) {
            System.out.println("Arrays are full");
        } else {
            this.values[indexOfElement] = value;
            this.keys[indexOfElement] = key;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < indexOfElement + 1; i++) {
            System.out.println(this.keys[i]);
            System.out.println(this.values[i]);
            if (Objects.equals(key, this.keys[i])) {
                return (V) this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < MAX_ARRAY_NUMBER; i++) {
            if (this.values[i] == null && this.keys[i] == null) {
                return i;
            }
        }
        return MAX_ARRAY_NUMBER;
    }
}
