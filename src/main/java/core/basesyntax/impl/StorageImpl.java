package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int size = 0;
    private final int maxItems = 10;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[maxItems];
        values = (V[]) new Object[maxItems];
    }

    public StorageImpl(K key, V value) {
        keys[size] = key;
        values[size] = value;
    }

    @Override
    public void put(K key, V value) {

        boolean interrupt = false;

        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                this.values[i] = value;
                interrupt = true;
            }
        }

        if (interrupt == false) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }
}
