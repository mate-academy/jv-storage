package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K key;
    private V value;
    private int size;
    private StorageImpl<K, V>[] arrayStorage;

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
        arrayStorage = new StorageImpl[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                arrayStorage[i] = new StorageImpl<>(key, value);
                size++;
                break;
            } else if (Objects.equals(arrayStorage[i].key, key)) {
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
            if (Objects.equals(arrayStorage[i].key, key)) {
                return arrayStorage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
