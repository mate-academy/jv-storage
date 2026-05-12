package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_Keys_And_Values = 10;
    protected final K[] keys;
    protected final V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_Keys_And_Values];
        this.values = (V[]) new Object[MAX_Keys_And_Values];
    }

    @Override
    public void put(K key, V value) {
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size();
    }
}
