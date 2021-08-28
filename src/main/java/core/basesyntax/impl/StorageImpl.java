package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM_ELEMENTS = 10;
    private K key;
    private V value;
    private StorageImpl<K,V>[] data;

    public StorageImpl() {
        data = new StorageImpl[MAX_ITEM_ELEMENTS];
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
            if (data[i] != null
                    && (key == data[i].key
                    || (key != null
                    && key.equals(data[i].key)))) {
                data[i].value = value;
                break;
            }
            if (data[i] == null) {
                data[i] = new StorageImpl<>(key, value);
                break;
            }
        }
        if (size() == -1) {
            System.out.println("There is't some space for record!");
        }
    }

    @Override
    public V get(K key) {
        V object = null;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null
                    && (key == data[i].key
                    || (key != null
                    && key.equals(data[i].key)))) {
                object = data[i].value;
                break;
            }
        }
        return object;
    }

    @Override
    public int size() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
