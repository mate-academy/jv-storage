package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object [][] storage = new Object[2][10];

    @Override
    public void put(K key, V value) {
        boolean haveEquals = false;
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(key, (storage[0][i]))) {
                storage[1][i] = value;
                haveEquals = true;
                break;
            }
        }
        if (!haveEquals) {
            for (int i = 0; i < storage[0].length; i++) {
                if (storage[0][i] == null && storage[1][i] == null) {
                    storage[0][i] = key;
                    storage[1][i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage[0].length; i++) {
            if (Objects.equals(key, storage[0][i])) {
                return (V) (storage[1][i]);
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < storage[1].length; i++) {
            if (storage[0][i] == null && storage[1][i] == null) {
                return i;
            }
        }
        return 0;
    }
}
