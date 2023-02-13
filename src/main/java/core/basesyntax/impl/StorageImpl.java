package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_LENGTH = 10;
    private K[] keysStore;
    private V[] valuesStore;
    private int length;

    public StorageImpl() {
        this.keysStore = (K[]) new Object[ARRAY_MAX_LENGTH];
        this.valuesStore = (V[]) new Object[ARRAY_MAX_LENGTH];
        length = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < length; i++) {
            if ((keysStore[i] == null && key == null)
                    ^ (keysStore[i] != null && keysStore[i].equals(key))) {
                valuesStore[i] = value;
                return;
            }
        }
        keysStore[length] = key;
        valuesStore[length] = value;
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if ((keysStore[i] == null && key == null)
                    ^ (keysStore[i] != null && keysStore[i].equals(key))) {
                return valuesStore[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }
}
