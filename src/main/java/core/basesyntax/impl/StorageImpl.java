package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int limit;

    public StorageImpl() {
        limit = 0;
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (!duplicateKey(key)) {
            this.keys[limit] = key;
            this.values[limit] = value;
            this.limit++;
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

    private boolean duplicateKey(K key) {
        for (K test : keys) {
            if (Objects.equals(test, key)) {
                return true;
            }
        }
        return false;
    }

}


