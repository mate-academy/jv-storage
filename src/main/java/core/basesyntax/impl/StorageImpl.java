package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            grow();
        } else if (index >= 0) {
            keys[index] = key;
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((((key == null && keys[i] == null)
                    || (keys[i] != null && keys[i].equals(key))) && values[i] != null)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        size++;
    }
}
