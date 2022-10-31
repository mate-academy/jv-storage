package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private K key;
    private V value;

    public int getIndex(K key) {
        int volume = size();
        int result = -1;
        if (key == null) {
            for (int i = 0; i < volume; i++) {
                if (keys[i] == null) {
                    result = i;
                }
            }
        } else {
            for (int i = 0; i < volume; i++) {
                if (key.equals(keys[i])) {
                    result = i;
                }
            }
        }
        return result;
    }

    @Override
    public void put(K key, V value) {
        int volume = size();
        if (volume == 0) {
            keys = new Object[MAX_NUMBER];
            values = new Object[MAX_NUMBER];
        }
        int index = getIndex(key);
        if (index < 0) {
            if (volume <= MAX_NUMBER) {
                keys[volume] = key;
                values[volume] = value;
            }
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index < 0) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        if (values == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < MAX_NUMBER; i++) {
            if (values[i] != null) {
                result = result + 1;
            }
        }
        return result;
    }
}
