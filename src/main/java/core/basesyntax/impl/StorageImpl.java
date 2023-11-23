package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.StorageObject;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final StorageObject[] storage = new StorageObject[10];

    private int size = 0;

    @Override
    public void put(K key, V value) {
        StorageObject<K, V> storageToAdd = new StorageObject<>(key, value);
        if (size <= storage.length) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = storageToAdd;
                    size++;
                    break;
                } else if (storage[i].getKey() == null
                        && storageToAdd.getKey() == null) {
                    storage[i] = storageToAdd;
                    break;
                } else if (storage[i].getKey() != null
                        && storage[i].getKey().equals(storageToAdd.getKey())) {
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
            } else if (object.getKey() == null && key == null) {
                return (V) object.getValue();
            } else if (object.getKey() != null
                    && object.getKey().equals(key)) {
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
