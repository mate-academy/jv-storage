package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int counter;

    public StorageImpl() {
        this.keys = (K[])(new Object[SIZE_OF_ARRAY]);
        this.values = (V[])(new Object[SIZE_OF_ARRAY]);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == keys[i]
                    || keys[i] != null && keys[i].equals(key)) && values[i] != null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == keys[i]
                    || keys[i] != null && keys[i].equals(key)) && values[i] != null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
