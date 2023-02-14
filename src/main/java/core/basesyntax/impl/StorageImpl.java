package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private static final int FIRST_INDEX = 0;
    private V[] value;
    private K[] key;
    private int index;

    public StorageImpl() {
        value = (V[]) new Object[LENGTH];
        key = (K[])new Object[LENGTH];
        index = FIRST_INDEX;
    }

    @Override
    public void put(K key, V value) {
        boolean keyWas = false;
        for (int i = 0; i < index; i++) {
            if (compare(this.key[i], key)) {
                this.value[i] = value;
                keyWas = true;
            }
        }
        if (keyWas == false) {
            this.key[index] = key;
            this.value[index] = value;
            index++;
        }
    }

    private boolean compare(Object first, Object second) {
        if (first == null || second == null) {
            if (first == second) {
                return true;
            } else {
                return false;
            }
        } else {
            return first.equals(second);
        }
    }

    @Override
    public V get(K key) {
        int indexResult = 0;
        for (int i = 0; i < index; i++) {
            if (compare(this.key[i], key)) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
