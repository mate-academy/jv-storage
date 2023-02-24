package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int storageCounter = 0;
    private int maxStorage = 10;
    private StorageImpl[] storages = new StorageImpl[maxStorage];

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        key = nullToString(key);
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {

        boolean interrupt = false;
        key = nullToString(key);

        for (int i = 0; i < storageCounter; i++) {
            if (storages[i].key.equals(key)) {
                storages[i].value = value;
                interrupt = true;
            }
        }

        if (interrupt == false) {
            storages[storageCounter] = new StorageImpl(key, value);
            storageCounter++;
        }
    }

    @Override
    public V get(K key) {

        key = nullToString(key);

        for (int i = 0; i < maxStorage; i++) {
            if (storages[i] != null) {
                if (storages[i].key.equals(key)) {
                    return (V) storages[i].value;
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return storageCounter;
    }

    public K nullToString(K key) {
        if (key == null) {
            key = (K) new String("null");
        }
        return key;
    }
}
