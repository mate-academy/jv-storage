package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int maxArraySize = 10;
    private K[] keys = (K[]) new Object[maxArraySize];
    private V[] values = (V[]) new Object[maxArraySize];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (keys[i] == key || (key != null && keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                break;
            } else if (i == maxArraySize) {
                System.out.println("You can't place a new key, dictionary is full");
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (key != null && keys[i] != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < keys.length; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return maxArraySize;
    }
}
