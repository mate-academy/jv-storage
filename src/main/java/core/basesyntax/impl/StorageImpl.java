package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals((K) keys[i], key)) {
                values[i] = value;
                if (size == 0) {
                    size++;
                }
                return;
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
