package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if ((key != null && keys[i] != null) && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                return (V) values[i];
            } else if (keys[i] == null && key != null) {
                continue;
            }
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int arraysSize = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null || keys[i] != null) {
                arraysSize++;
            }
        }
        return arraysSize;
    }
}
