package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int count;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_SIZE];
        this.values = (V[]) new Object[STORAGE_SIZE];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (indexOfKey(key) == -1) {
            keys[count] = key;
            values[count] = value;
            count = count + 1;
        }
        values[indexOfKey(key)] = value;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(Object key) {
        if (indexOfKey((K) key) != -1) {
            return values[indexOfKey((K) key)];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(keys[i]).append(", ").append(values[i]).append("\n");
        }
        return sb.toString();
    }
}
