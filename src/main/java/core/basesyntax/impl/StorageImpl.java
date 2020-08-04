package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_LENGTH = 10;

    public Object[] keyStorage;
    public Object[] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[ARRAY_LENGTH];
        valueStorage = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null
                    & !Arrays.stream(keyStorage).anyMatch(check -> check == key)) {
                keyStorage[i] = key;
                valueStorage[i] = value;
            }
            if (keyStorage[i] == key
                    && !Arrays.stream(valueStorage).anyMatch(check -> check == value)) {
                valueStorage[i] = value;
            }
        }
    }

    @Override
    public V get(K key) { // такой код работает //
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (key == keyStorage[i]) {
                return (V) valueStorage[i];
            }
        }
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (key.equals(keyStorage[i])) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }
}
