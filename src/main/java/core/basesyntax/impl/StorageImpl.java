package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int count = 0;

    public StorageImpl() {
        keyStorage = (K[]) new Object[ARRAY_LENGTH];
        valueStorage = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                count++;
                return;
            } else if (Objects.equals(keyStorage[i], key)) {
                keyStorage[i] = key;
                valueStorage[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
