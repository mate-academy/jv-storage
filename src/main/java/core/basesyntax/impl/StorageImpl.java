package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    private final V[] values = (V[]) new Object[MAX_ITEMS_NUMBER];

    private int counter = 0;

    public boolean keyCheck(K key) {
        counter = 0;
        for (int i = 0; i < this.values.length; i++) {
            if (this.keys[i] == null && this.values[i] != null
                    && key == null || this.keys[i] != null
                    && this.keys[i].equals(key)) {
                counter = i;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        counter = 0;
        for (int i = 0; i < this.values.length; i++) {
            if (this.keys[i] == null && this.values[i] == null) {
                counter = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        if (keyCheck(key) || isEmpty()) {
            this.keys[counter] = key;
            this.values[counter] = value;
        }
    }

    @Override
    public V get(K key) {
        if (keyCheck(key)) {
            return this.values[counter];
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object value : this.values) {
            if (value != null) {
                counter++;
            }
        }
        return counter;
    }
}
