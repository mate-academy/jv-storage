package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBERS = 10;
    private Object[] key;
    private Object[] value;
    private int currentSize;

    public StorageImpl() {
        this.key = new Object[MAX_ELEMENT_NUMBERS];
        this.value = new Object[MAX_ELEMENT_NUMBERS];
        this.currentSize = 0;
    }

    K getSingleKey(int i) {
        return (K) key [i];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            this.value[currentSize] = value;
            this.key[currentSize] = key;
            currentSize++;
        } else {
            for (int i = 0; i < currentSize; i++) {
                if ((getSingleKey(i) == null && key == null) || getSingleKey(i).equals(key)) {
                    this.value[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((getSingleKey(i) == null && key == null)
                    || ((getSingleKey(i) != null && getSingleKey(i).equals(key)))) {
                return (V) value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
