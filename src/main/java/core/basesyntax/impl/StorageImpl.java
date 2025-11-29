package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;
    private final Entry<K, V>[] entries;
    private int size;

    private static class Entry<K, V> {
        private K key;
        private V value;

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

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        entries = (Entry<K, V>[]) Array.newInstance(Entry.class, MAX_CAPACITY);
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isElementTheSame = false;
        Entry<K, V> entry = new Entry<>();
        entry.setKey(key);
        entry.setValue(value);
        for (int i = 0; i < size; i++) {
            if (checkKeys(entries[i].getKey(), key)) {
                entries[i] = entry;
                isElementTheSame = true;
                break;
            }
        }
        if (size < MAX_CAPACITY && !isElementTheSame) {
            entries[size] = entry;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(entries[i].getKey(), key)) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    private boolean checkKeys(K arrayKey, K key) {
        return arrayKey == key || (arrayKey != null && arrayKey.equals(key));
    }

    @Override
    public int size() {
        return size;
    }
}
