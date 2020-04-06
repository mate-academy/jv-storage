package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private int top = 0;

    public StorageImpl() {
        this.keys = new Object[10];
        this.values = new Object[10];
    }

    @Override
    public void put(K key, V value) {
        boolean notHere = true;
        for (int i = 0; i < top; i++) {
            if (compare(key, i)) {
                values[i] = value;
                notHere = false;
                break;
            }
        }
        if ((notHere || key == null) && top != keys.length) {
            keys[top] = key;
            values[top] = value;
            top++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < top; i++) {
            if (compare(key, i)) {
                return (V) values[i];
            }
        }
        return null;
    }

    boolean compare(K key, int i) {
        return Objects.equals(keys[i], key);
    }
}
