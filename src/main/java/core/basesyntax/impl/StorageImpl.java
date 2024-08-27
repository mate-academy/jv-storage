package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int count = 0;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (keysAreEqual(key, (K) keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (count < keys.length) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new RuntimeException("Massive is full!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (keysAreEqual(key, (K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean keysAreEqual(K key, K key2) {
        return (key == null && key2 == null) || (key != null && key.equals(key2));
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("keys:[");
        for (int i = 0; i < count; i++) {
            sb.append(keys[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("], values[");
        for (int i = 0; i < count; i++) {
            sb.append(values[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
