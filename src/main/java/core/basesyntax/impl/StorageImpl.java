package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private StorageImpl<K, V>[] storage = new StorageImpl[10];
    private K key;
    private V value;
    private byte size = 0;

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && key == null && storage[i].key == null) {
                storage[i].value = value;
                break;
            }
            if ((storage[i] != null && storage[i].key != null) && (storage[i].key.equals(key))) {
                storage[i].value = value;
                break;
            }
            if (storage[i] == null) {
                storage[i] = new StorageImpl<>(key, value);
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> currentItem : storage) {
            if (currentItem != null && key == null && currentItem.key == null) {
                return currentItem.value;
            }
            if (currentItem != null && currentItem.key != null && currentItem.key.equals(key)) {
                return currentItem.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
