package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final float DEFAULT_CAPACITY_INCREASE_FACTOR = 1.5f;

    private int initialCapacity;
    private float loadFactor;
    private float capacityIncreaseFactor;
    private StorageObject<K, V>[] storage;
    private int size;

    public StorageImpl() {
        initialCapacity = DEFAULT_INITIAL_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        capacityIncreaseFactor = DEFAULT_CAPACITY_INCREASE_FACTOR;
        this.storage = new StorageObject[initialCapacity];
    }

    public StorageImpl(int initialCapacity, float loadFactor, float capacityIncreaseFactor) {
        if (initialCapacity > 0) {
            this.initialCapacity = initialCapacity;
        } else {
            this.initialCapacity = DEFAULT_INITIAL_CAPACITY;
        }
        if (loadFactor >= 0.1f && loadFactor <= 0.9f) {
            this.loadFactor = loadFactor;
        } else {
            this.loadFactor = DEFAULT_LOAD_FACTOR;
        }
        if (capacityIncreaseFactor >= 1.1f && capacityIncreaseFactor <= 2) {
            this.capacityIncreaseFactor = capacityIncreaseFactor;
        } else {
            this.capacityIncreaseFactor = DEFAULT_CAPACITY_INCREASE_FACTOR;
        }
        this.storage = new StorageObject[this.initialCapacity];
    }

    public class StorageObject<K, V> {
        private K key;
        private V value;

        public StorageObject(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean keyCheck(K key) {
            return ((key == null && this.key == null)
                    || (this.key != null && this.key.equals(key)));
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].keyCheck(key)) {
                storage[i].value = value;
                return;
            }
        }
        this.checkingForCompleteness();
        storage[size] = new StorageObject<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storage[i].keyCheck(key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    public V getByHashCode(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && storage[i].key == null)
                    || (storage[i].key != null && key != null
                    && storage[i].key.hashCode() == key.hashCode())) {
                return storage[i].value;
            }
        }
        return null;
    }

    private void checkingForCompleteness() {
        if (((float) size / storage.length) > loadFactor) {
            StorageObject<K, V>[] newStorage
                    = new StorageObject[(int) (storage.length * capacityIncreaseFactor)];
            for (int i = 0; i < size; i++) {
                newStorage[i] = storage[i];
            }
            storage = newStorage;
        }
    }

    public void remove(K key) {
        int index = -1;
        boolean indexFound = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].keyCheck(key)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            StorageObject<K, V>[] newStorage = new StorageObject[storage.length - 1];
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    indexFound = true;
                } else {
                    if (indexFound) {
                        newStorage[i - 1] = storage[i];
                    } else {
                        newStorage[i] = storage[i];
                    }
                }
            }
            storage = newStorage;
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
