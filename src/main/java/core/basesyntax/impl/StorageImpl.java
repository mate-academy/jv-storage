package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM_ELEMENTS = 10;
    private K key;
    private V value;
    private int size;
    private StorageImpl<K,V>[] data;

    public StorageImpl() {
        data = new StorageImpl[MAX_ITEM_ELEMENTS];
        size = 0;
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) o;
        return (key == storage.key
                || (storage.key != null
                && storage.key.equals(key)))
                && (value == storage.value
                || (storage.value != null
                && storage.value.equals(value)));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < data.length; i++) {
            if (isKeyConsist(key, i)) {
                data[i].value = value;
                return;
            }
            if (data[i] == null) {
                data[i] = new StorageImpl<>(key, value);
                size++;
                return;
            }
        }
        if (size() == MAX_ITEM_ELEMENTS) {
            System.out.println("There is't some space for record!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < data.length; i++) {
            if (isKeyConsist(key, i)) {
                return data[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyConsist(K key, int index) {
        return data[index] != null
                && (key == data[index].key
                || (key != null
                && key.equals(data[index].key)));
    }
}
