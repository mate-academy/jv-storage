package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private final StorageImpl<K, V>[] storageArray = new StorageImpl[10];

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        StorageImpl<K, V> element = new StorageImpl<>(key, value);
        if (storageArray[0] == null) {
            storageArray[0] = element;
        }
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i] == null || (storageArray[i].getKey() == null && key == null)) {
                storageArray[i] = element;
                break;
            }
            if (storageArray[i].getKey() != null && storageArray[i].getKey().equals(key)) {
                storageArray[i] = element;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> element : storageArray) {
            if (element == null) {
                return null;
            }
            if (element.getKey() == null && key == null
                    || (element.getKey() != null && element.getKey().equals(key))) {
                return element.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (StorageImpl<K, V> element : storageArray) {
            if (element != null) {
                size++;
            }
        }
        return size;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
