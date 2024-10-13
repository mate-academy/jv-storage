package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Pair<K, V>[] items;

    public StorageImpl() {
        this.items = new Pair[STORAGE_DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areBothKeysNull(items[i].getKey(), key)) {
                items[i].setValue(value);
                return;
            }
            if (areKeysEqual(key, items[i].getKey())) {
                items[i] = new Pair<>(key, value);
                return;
            }
        }
        if (size == STORAGE_DEFAULT_CAPACITY - 1) {
            increaseStorageSize();
        }
        items[size] = new Pair<>(key, value);
        size++;
    }

    private boolean areBothKeysNull(K firstKey, K secondKey) {
        return secondKey == null && firstKey == null;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, items[i].getKey())) {
                return items[i].getValue();
            }
            if (items[i].getKey() == null && key == null) {
                return items[i].getValue();
            }
        }
        return null;
    }

    private boolean areKeysEqual(K firstKey, K secondKey) {
        return secondKey != null && secondKey.equals(firstKey);
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseStorageSize() {
        items = Arrays.copyOf(items, items.length * 2);
    }
}
