package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K keyClasses;
    private V valueClasses;

    private StorageImpl[] storages = new StorageImpl[10];

    public StorageImpl() {
    }

    public StorageImpl(K keyClasses, V valueClasses) {
        this.keyClasses = keyClasses;
        this.valueClasses = valueClasses;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storages.length; i++) {
            if (storages[i] != null) {
                if (storages[i].keyClasses == null && key != null) {
                    continue;
                }
                if (storages[i].keyClasses == key || storages[i].keyClasses.equals(key)) {
                    storages[i] = new StorageImpl(key, value);
                    break;
                }
            }
            if (storages[i] == null) {
                storages[i] = new StorageImpl(key, value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storages.length; i++) {
            if (storages[i] == null) {
                continue;
            }
            if (storages[i].keyClasses == null && key != null) {
                continue;
            }
            if (storages[i].keyClasses == null && key == null) {
                return (V) storages[i].valueClasses;
            }
            if (storages[i] == null) {
                continue;
            }
            if (storages[i].keyClasses.equals(key)) {
                return (V) storages[i].valueClasses;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (StorageImpl storage : storages) {
            if (storage == null) {
                break;
            }
            counter++;
        }
        return counter;
    }
}
