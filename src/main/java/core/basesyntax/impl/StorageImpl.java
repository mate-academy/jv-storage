package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_STORAGE_SIZE = 15;
    private static final int MINIMUM_STORAGE_SIZE = 5;
    private static final int DEFAULT_STORAGE_GROW_FACTOR = 1;
    private static final double DEFAULT_LOAD_CAPACITY = 0.5;
    private int storageSize;
    private int currentSize;
    private boolean isGrowable;
    private Object[] entries;

    public StorageImpl() {
        storageSize = DEFAULT_STORAGE_SIZE;
        currentSize = 0;
        entries = new Object[DEFAULT_STORAGE_SIZE];
        isGrowable = false;
    }

    public StorageImpl(boolean isGrowable) {
        this();
        this.isGrowable = isGrowable;
    }

    public StorageImpl(int storageSize) {
        if (storageSize <= MINIMUM_STORAGE_SIZE) {
            throw new IllegalArgumentException("Can't create "
                    + "Storage with size less than or equal "
                    + MINIMUM_STORAGE_SIZE);
        }
        this.storageSize = storageSize;
        currentSize = 0;
        this.entries = new Object[storageSize];
        isGrowable = false;
    }

    static class Entry<K, V> {
        private final K key;
        private final Integer hashCode;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value, Integer hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            next = null;
        }

        public Integer getHashCode() {
            return hashCode;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void put(K key, V value) {
        Entry<K, V> entry;
        checkCapacity();
        int hashCode = getHashCode(key);
        int index = Math.abs(hashCode % storageSize);
        if (entries[index] != null) {
            Entry<K, V> existed = (Entry<K, V>) entries[index];
            if (existed.getHashCode().equals(hashCode)) {
                existed.setValue(value);
            } else {
                entry = new Entry<>(key, value, hashCode);
                existed.setNext(entry);
                currentSize++;
            }
        } else {
            entry = new Entry<>(key, value, hashCode);
            entries[index] = entry;
            currentSize++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        Entry<K, V> entry;
        Integer hashCode = getHashCode(key);
        int index = Math.abs(hashCode % storageSize);
        if (entries[index] != null) {
            entry = (Entry<K, V>) entries[index];
            if (entry.getHashCode().equals(hashCode)) {
                return entry.getValue();
            } else {
                Entry<K, V> next = entry.getNext();
                while (next != null) {
                    if (next.getHashCode().equals(hashCode)) {
                        return next.getValue();
                    }
                    next = next.getNext();
                }
                return null;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private Integer getHashCode(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private void checkCapacity() {
        if (isGrowable) {
            double currentLoad = (double) currentSize / storageSize;
            if (currentLoad >= DEFAULT_LOAD_CAPACITY) {
                reformateStorage();
            }
        } else {
            int left = storageSize - currentSize;
            if (left == 0) {
                throw new RuntimeException("Storage is full! "
                        + "Parameter <isGrowable> was set to false. "
                        + "Max size is " + storageSize);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void reformateStorage() {
        storageSize = storageSize << DEFAULT_STORAGE_GROW_FACTOR;
        Object[] newEntries = new Object[storageSize];
        Object[] oldEntries = entries;
        entries = newEntries;
        currentSize = 0;
        for (Object oldEntry : oldEntries) {
            if (oldEntry != null) {
                Entry<K, V> entry = (Entry<K, V>) oldEntry;
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
