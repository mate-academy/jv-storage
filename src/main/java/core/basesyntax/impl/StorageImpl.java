package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM_ELEMENTS = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int size;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_ITEM_ELEMENTS];
        valueStorage = (V[]) new Object[MAX_ITEM_ELEMENTS];
    }

    public StorageImpl(K key, V value) {
        keyStorage[size] = key;
        valueStorage[size] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        K newObject = (K) new Object();
        return newObject.equals(this);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEM_ELEMENTS; i++) {
            if (isKeyConsist(key, i)) {
                valueStorage[i] = value;
                return;
            }
            if (valueStorage[i] == null) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                size++;
                return;
            }
        }
        if (size() == MAX_ITEM_ELEMENTS) {
            System.out.println("There is't some space for record!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEM_ELEMENTS; i++) {
            if (isKeyConsist(key, i)) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyConsist(K key, int index) {
        return valueStorage[index] != null
                && (key == keyStorage[index]
                || (key != null
                && key.equals(keyStorage[index])));
    }
}
