package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private final StorageImpl<K, V>[] storage;
    private K key;
    private V value;

    public StorageImpl() {
        storage = new StorageImpl[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        StorageImpl<K, V> newCell = of(key, value);
        int indexOfStorageCell = isDuplicate(key) ? size() - 1 : size();
        storage[indexOfStorageCell] = newCell;
    }

    private static <K, V> StorageImpl<K, V> of(K key, V value) {
        StorageImpl<K, V> kvStorage = new StorageImpl<>();
        kvStorage.setKey(key);
        kvStorage.setValue(value);
        return kvStorage;
    }

    private boolean isDuplicate(K key) {
        if (size() - 1 != -1) {
            K previousCellKey = storage[size() - 1].getKey();
            return (previousCellKey == null && key == null)
                    || (previousCellKey != null
                    && previousCellKey.equals(key));
        }
        return false;
    }

    @Override
    public int size() {
        int storageSize = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storageSize = i;
                break;
            }
        }
        return storageSize;
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> cell : storage) {
            if (cell != null && ((cell.getKey() == null && key == null)
                    || (cell.getKey() != null && cell.getKey().equals(key)))) {
                return cell.getValue();
            }
        }
        return null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
