package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int VALUE_OF_NULL = -1;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int size = 0;

    public StorageImpl() {
        keyStorage = new Object[MAX_CAPACITY];
        valueStorage = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == null && valueStorage[i] == null) {
                keyStorage[i] = Objects.requireNonNullElse(key, VALUE_OF_NULL);
                valueStorage[i] = value;
                size++;
                break;
            } else if (keysEquals(key, keyStorage[i])) {
                valueStorage[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] != null) {
                if (keysEquals(key, keyStorage[i])) {
                    return (V) valueStorage[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEquals(Object mainKey, Object writtenKey) {
        if (mainKey == null && writtenKey.equals(VALUE_OF_NULL)) {
            return true;
        } else if (mainKey == null || writtenKey.equals(VALUE_OF_NULL)) {
            return false;
        }
        return writtenKey.equals(mainKey);
    }
}
