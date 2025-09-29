package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final StorageCell<K, V>[] storageCells;

    public StorageImpl() {
        this.storageCells = (StorageCell<K, V>[]) new StorageCell[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            this.storageCells[index].setValue(value);
        } else {
            if (size() == MAX_CAPACITY) {
                throw new IllegalStateException("Too many items in storage");
            }
            this.storageCells[size()] = new StorageCell<K, V>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index != -1
                ? this.storageCells[index].getValue()
                : null;
    }

    @Override
    public int size() {
        int count = 0;
        for (StorageCell<K, V> storageCell : this.storageCells) {
            if (storageCell != null) {
                count++;
            }
        }
        return count;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < this.storageCells.length; i++) {
            StorageCell<K, V> storageCell = this.storageCells[i];
            if (storageCell == null) {
                continue;
            }
            K storageKey = storageCell.getKey();
            if (storageKey == key || storageKey != null && storageKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
