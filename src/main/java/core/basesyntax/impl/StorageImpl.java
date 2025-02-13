package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K key;
    private V value;
    private final StorageImpl[] arrayStorage = new StorageImpl[ARRAY_LENGTH];

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                arrayStorage[i] = new StorageImpl<>(key, value);
                break;
            } else if (arrayStorage[i].key == key || arrayStorage[i].key != null
                    && arrayStorage[i].key.equals(key)) {
                arrayStorage[i].value = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                break;
            }
            if (arrayStorage[i].key == key || arrayStorage[i].key != null
                    && arrayStorage[i].key.equals(key)) {
                return (V) arrayStorage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }
}
