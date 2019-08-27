package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int elementsQ = 0;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < elementsQ; i++) {
            if ((keys[i] == null && key == null) || keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (elementsQ == keys.length) {
            resize(elementsQ * 2);
        }
        keys[elementsQ] = key;
        values[elementsQ] = value;
        elementsQ++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsQ; i++) {
            if ((keys[i] == null && key == null) || keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    private void resize(int capacity) {
        if (capacity < elementsQ) {
            return;
        }
        K[] keysClone = (K[]) new Object[capacity];
        V[] valuesClone = (V[]) new Object[capacity];
        for (int i = 0; i < elementsQ; i++) {
            keysClone[i] = keys[i];
            valuesClone[i] = values[i];
        }
        keys = keysClone;
        values = valuesClone;
    }
}

