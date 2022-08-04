package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private K key;
    private V value;
    private final Object[] keys = new Object[ARRAY_SIZE];
    private final Object[] values = new Object[ARRAY_SIZE];
    private int exist = -1;
    private int keysSize = -1;

    @Override
    public void put(K key, V value) {
        if (keysSize == -1) {
            keysSize++;
            this.keys[keysSize] = key;
            this.values[keysSize] = value;
        } else {
            for (int i = 0; i < keysSize + 1; i++) {
                if (key != null && key.equals(keys[i]) || key == keys[i]) {
                    exist = i;
                }
            }
            if (exist != -1) {
                this.keys[exist] = key;
                this.values[exist] = value;
            } else {
                keysSize++;
                this.keys[keysSize] = key;
                this.values[keysSize] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int size() {
        return keysSize + 1;
    }
}
