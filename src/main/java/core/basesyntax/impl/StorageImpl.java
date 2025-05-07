package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.StorageObject;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int PRIMARY_SIZE = 0;
    private final StorageObject[] storage;
    private int size;

    public StorageImpl() {
        this.size = PRIMARY_SIZE;
        storage = new StorageObject[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        StorageObject<K, V> storageToAdd = new StorageObject<>(key, value);
        if (size <= storage.length) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = storageToAdd;
                    size++;
                    break;
                } else if ((storage[i].getKey() == null
                        && storageToAdd.getKey() == null)
                        || (storage[i].getKey() != null
                        && storage[i].getKey().equals(storageToAdd.getKey()))) {
                    storage[i] = storageToAdd;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageObject object : storage) {
            if (object == null) {
                break;
            } else if (object.getKey() == null && key == null
                    || (object.getKey() != null
                    && object.getKey().equals(key))) {
                return (V) object.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
