package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    @SuppressWarnings("unchecked")
    private K[] keys = (K[]) new Object[1];
    @SuppressWarnings("unchecked")
    private V[] values = (V[]) new Object[1];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            resize();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        System.out.println("There is no such key");
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        K[] newKeys = (K[]) new Object[keys.length + 1];
        @SuppressWarnings("unchecked")
        V[] newValues = (V[]) new Object[values.length + 1];
        System.arraycopy(keys, 0, newKeys, 0, size());
        System.arraycopy(values, 0, newValues, 0, size());
        keys = newKeys;
        values = newValues;
    }
}
