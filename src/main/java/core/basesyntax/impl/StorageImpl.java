package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null & values[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }
        } else {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                value = (V) values[i];
                break;
            } else if (key == keys[i]) {
                value = (V) values[i];
                break;
            }
        }
        return value;
    }
}
