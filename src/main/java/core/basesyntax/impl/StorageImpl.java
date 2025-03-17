package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private StorageImpl<K, V>[] storage = (StorageImpl<K, V>[]) new StorageImpl[10];

    public StorageImpl() {
        this.key = null;
        this.value = null;
    }

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

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
                storage[i] = new StorageImpl<>();
                storage[i].setKey(key);
                storage[i].setValue(value);
                return;
            }

            if ((key == null && storage[i].getKey() == null)
                    || (key != null && key.equals(storage[i].getKey()))) {

                storage[i].setValue(value);
                return;
            }
        }
        System.out.println("Array full.");
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> kvStorage : storage) {
            if (kvStorage != null && kvStorage.getKey() != null && kvStorage.getKey().equals(key)) {
                return kvStorage.getValue();
            }
            if (kvStorage != null && kvStorage.getKey() == null && key == null) {
                return kvStorage.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
                return i;
            }
        }

        return 10;
    }
}
