package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int index = 0;
    private int capacity = 16;
    private K[] keys = (K[]) new Object[capacity];
    private V[] values = (V[]) new Object[capacity];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if ((keys[i] == null && key == null) || keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            System.out.println(values[i]);
            if ((key == null && keys[i] == null)
                    || keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
