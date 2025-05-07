package core.basesyntax.impl;

import core.basesyntax.Element;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Element<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Element[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (keysComparing(key, storage[i].getKey())) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size < STORAGE_SIZE) {
            Element<K, V> element = new Element<>(key, value);
            storage[size++] = element;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (keysComparing(key, storage[i].getKey())) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysComparing(K key, K storageKey) {
        return (key == storageKey) || (key != null && key.equals(storageKey));
    }
}
