package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keyStorage;
    private V[] valueStorage;
    private int index;

    public StorageImpl() {
        index = 0;
        keyStorage = (K[]) new Object[LENGTH];
        valueStorage = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (find(key) >= 0) {
            for (int i = 0; i < keyStorage.length; i++) {
                if (compare(keyStorage[i], key)) {
                    valueStorage[i] = value;
                }
            }
        } else {
            keyStorage[index] = key;
            valueStorage[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (compare(keyStorage[i], key)) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    private int find(K key) {
        return Arrays.asList(keyStorage).indexOf(key);
    }

    private boolean compare(K firstKey, K secondKey) {
        return firstKey == secondKey
                || (firstKey != null && firstKey.equals(secondKey));
    }
}
