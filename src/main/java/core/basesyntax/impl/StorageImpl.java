package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K key;
    private V value;
    private int count = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_SIZE];
        this.values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (indexOfKey(keys, key) == -1 || key == null && get(key) != null) {
            keys[count] = key;
            values[count] = value;
            count = count + 1;
        } else {
            values[indexOfKey(keys, key)] = value;
        }
    }

    private int indexOfKey(K[] keys, K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(Object key) {
        int indexByKey = 0;
        for (int i = 0; i < count; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                indexByKey = i;
            }
        }
        return values[indexByKey];
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
