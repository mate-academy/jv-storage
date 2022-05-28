package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((values[i] == null)
                    || (key == keys[i] && values[i] != null)
                    || ((key == keys[i]) || (key != null && key.equals(keys[i])))) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || ((key != null) && (key.equals(keys[i])))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int index = 0;
        for (Object obj : values) {
            if (obj != null) {
                index++;
            }
        }
        return index;
    }
}
