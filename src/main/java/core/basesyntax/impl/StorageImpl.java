package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final StorageCell<K, V>[] array = new StorageCell[MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        boolean present = false;
        for (StorageCell<K, V> storageCell : this.array) {
            if (storageCell == null) {
                continue;
            }
            K storageKey = storageCell.getKey();
            if (storageKey == key || storageKey != null && storageKey.equals(key)) {
                storageCell.setValue(value);
                present = true;
            }
        }
        if (!present) {
            if (size() == MAX_CAPACITY) {
                throw new IllegalStateException("Too many items in storage");
            }
            this.array[size()] = new StorageCell<K, V>(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (StorageCell<K, V> storageCell : this.array) {
            if (storageCell == null) {
                continue;
            }
            K storageKey = storageCell.getKey();
            if (storageKey == key || storageKey != null && storageKey.equals(key)) {
                return storageCell.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (StorageCell<K, V> storageCell : this.array) {
            if (storageCell != null) {
                count++;
            }
        }
        return count;
    }
}
