package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private static int sizeStorage;
    private ElementStorage<K, V>[] storage;

    public StorageImpl() {
        this.storage = new ElementStorage[MAX_SIZE_STORAGE];
        this.sizeStorage = 0;
    }

    class ElementStorage<K, V> {
        private K key;
        private V value;

        public ElementStorage(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        int index = containsKey(key);
        if (index >= 0) {
            storage[index] = new ElementStorage(key, value);
        } else {
            storage[sizeStorage++] = new ElementStorage(key, value);
        }
    }

    private int containsKey(K key) {
        if (this.size() == 0) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].key == null && key == null) {
                return i;
            }
            if (storage[i].key != null && storage[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = containsKey(key);
        return index >= 0 ? storage[index].value : null;
    }

    @Override
    public int size() {
        return sizeStorage;
    }
}
