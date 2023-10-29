package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INDEX_ZERO = 0;
    private static final int STORAGE_LENGTH = 10;
    private final StorageImpl<K, V>[] storage;
    private K key;
    private V value;
    private int index = 0;

    public StorageImpl() {
        storage = new StorageImpl[STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (storage[INDEX_ZERO] == null) {
            for (int i = 0; i < STORAGE_LENGTH; i++) {
                storage[i] = new StorageImpl<>();
            }
        }
        for (int i = 0; i < index; i++) {
            if (equalKey(storage[i].key, key)) {
                storage[i].value = value;
                return;
            }
        }
        storage[index].key = key;
        storage[index].value = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> element : storage) {
            if (equalKey(element.key, key)) {
                return element.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }

    public boolean equalKey(K firstKey, K secondKey) {
        return firstKey == null
                && secondKey == null
                || (firstKey != null
                && firstKey.equals(secondKey));
    }
}
