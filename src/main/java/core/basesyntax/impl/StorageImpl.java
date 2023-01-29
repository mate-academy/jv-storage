package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_QUANTITY = 10;
    private K key;
    private V value;
    private StorageImpl[] storages = new StorageImpl[MAX_ITEMS_QUANTITY];

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl(StorageImpl[] storages) {
        this.storages = storages;
    }

    public K getKey() {
        return (K) this.key;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_QUANTITY; i++) {
            StorageImpl<K, V> inputValue = new StorageImpl<>(key, value);
            if (isNull(storages[i])) {
                storages[i] = inputValue;
                break;
            } else if (isNull((K) storages[i].getKey()) && !isNull((K) inputValue.getKey())) {
                continue;
            } else if (areKeysEqual(storages[i], inputValue.getKey())) {
                storages[i] = inputValue;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> storage : storages) {
            if (isNull(storage)) {
                return null;
            } else if (isNull((K) storage.getKey()) && isNull(key)) {
                return storage.value;
            } else if (isNull((K) storage.getKey()) && !isNull(key)) {
                continue;
            } else if (areKeysEqual(storage, key)) {
                return storage.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int storageSize;
        for (storageSize = 0; storageSize < MAX_ITEMS_QUANTITY; storageSize++) {
            if (isNull(storages[storageSize])) {
                break;
            }
        }
        return storageSize;
    }

    private boolean isNull(StorageImpl storage) {
        return storage == null ? true : false;
    }

    private boolean isNull(K key) {
        return key == null ? true : false;
    }

    private boolean areKeysEqual(StorageImpl storage, K key) {
        return ((isNull((K) storage.getKey()) && isNull(key))
            || storage.getKey() == key
            || storage.getKey().equals(key));
    }
}
