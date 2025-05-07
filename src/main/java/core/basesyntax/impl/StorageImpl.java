package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int sizeStorage = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeStorage; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[sizeStorage] = key;
        values[sizeStorage] = value;
        sizeStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeStorage;
    }
}
