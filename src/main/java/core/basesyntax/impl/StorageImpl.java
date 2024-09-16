package core.basesyntax.impl;

import core.basesyntax.Entry;
import core.basesyntax.Storage;

@SuppressWarnings("-Xlint:unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ENTRY_ITEMS_NUMBER = 10;
    private final Entry<K, V>[] entries;
    private int size;

    public StorageImpl() {
        entries = new Entry[ENTRY_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEqualKeys(key, entries[i].getKey())) {
                entries[i].setValue(value);
                return;
            }
        }
        try {
            entries[size] = new Entry<>(key, value);
            size++;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("The storage can have a maximum of"
                    + ENTRY_ITEMS_NUMBER + " entries", e);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqualKeys(key, entries[i].getKey())) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    private boolean isEqualKeys(K key, K entryKey) {
        if (key == null && entryKey == null) {
            return true;
        }
        if (key == null || entryKey == null) {
            return false;
        }
        return key.equals(entryKey);
    }

    @Override
    public int size() {
        return size;
    }
}
