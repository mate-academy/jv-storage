package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 15;
    private int currentSize;
    private final Object[] entries;

    public StorageImpl() {
        currentSize = 0;
        entries = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        checkCapacity();
        int hashCode = getHashCode(key);
        int index = Math.abs(hashCode % STORAGE_SIZE);
        if (entries[index] != null) {
            addOrUpdateEntry(key, value, index);
        } else {
            addNewEntry(key, value, index);
        }
    }

    @Override
    public V get(K key) {
        int hashCode = getHashCode(key);
        int index = Math.abs(hashCode % STORAGE_SIZE);
        if (entries[index] != null) {
            if (key == null) {
                return getNullKey(index);
            } else {
                return getNonNullKey(key, index);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int getHashCode(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private void checkCapacity() {
        int spaceLeft = STORAGE_SIZE - currentSize;
        if (spaceLeft == 0) {
            throw new RuntimeException("Storage is full! "
                    + "Parameter <isGrowable> was set to false. "
                    + "Max size is " + STORAGE_SIZE);
        }
    }

    private void addNewEntry(K key, V value, int index) {
        Entry<K, V> entry = new Entry<>(key, value);
        entries[index] = entry;
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    private void addOrUpdateEntry(K key, V value, int index) {
        Entry<K, V> existed = (Entry<K, V>) entries[index];
        if (key == null && existed.getKey() == null) {
            existed.setValue(value);
        } else if (existed.getKey().equals(key)) {
            existed.setValue(value);
        } else {
            Entry<K, V> entry = new Entry<>(key, value);
            while (true) {
                Entry<K, V> temporary = existed.getNext();
                if (temporary == null) {
                    existed.setNext(entry);
                    break;
                } else {
                    existed = temporary;
                }
            }
            currentSize++;
        }
    }

    @SuppressWarnings("unchecked")
    private V getNullKey(int index) {
        Entry<K, V> entry = (Entry<K, V>) entries[index];
        while (entry != null) {
            if (entry.getKey() == null) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private V getNonNullKey(K key, int index) {
        Entry<K, V> entry = (Entry<K, V>) entries[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        private V getValue() {
            return value;
        }

        private K getKey() {
            return key;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private Entry<K, V> getNext() {
            return next;
        }

        private void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
