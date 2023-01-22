package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    public boolean keyCheck(K keys, K key) {
        return keys == null && key == null || keys != null
                && keys.equals(key);
    }

    public boolean isEmpty(K keys, V values) {
        if (keys == null && values == null) {
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.values.length; i++) {
            if (keyCheck(this.keys[i], key) && this.values[i] != null
                    || isEmpty(this.keys[i], this.values[i])) {
                this.keys[i] = key;
                this.values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.values.length; i++) {
            if (keyCheck(this.keys[i], key)) {
                return this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
