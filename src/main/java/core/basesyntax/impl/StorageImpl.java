package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)
                    || keys[i] == null && keys[i] == key && i < count) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            try {
                if (key == null && keys[i] == key || keys[i].equals(key)) {
                    return values[i];
                }
            } catch (NullPointerException e) {
                System.out.println("the key does not exist");
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
