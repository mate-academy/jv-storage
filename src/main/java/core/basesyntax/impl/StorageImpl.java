package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    final private int SIZE = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        count = 0;
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    private boolean ifExist(K key) {
        for (K k : keys) {
            if (Objects.equals(key, k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        if (!ifExist(key)) {
            this.keys[count] = key;
            this.values[count] = value;
            count++;
        } else {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == key) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }
}
