package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;
    protected K[] keys;
    protected V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];
        this.values = (V[]) new Object[MAX_CAPACITY];
        this.size = 0;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
