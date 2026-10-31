package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private static int size = 0;

    public void StorageImpl() {
        this.keys = (K[]) new Object[10];
        this.values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (this.keys.length < 10) {
            this.keys[this.keys.length] = key;
            this.values[this.keys.length] = value;
        }
        size++;
    }

    @Override
    public V get(K key) {
        int i = 0;
        for (K keyElement : this.keys) {
            if (keyElement == key) {
                break;
            }
            i++;
        }
        if (keyElement == key) {
            return this.values[i];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
