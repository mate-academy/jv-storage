package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int SIZE_OF_STORAGE = 10;
    private final Cargo<K, V>[] cargos;

    public StorageImpl() {
        this.cargos = (Cargo<K, V>[]) new Cargo[SIZE_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);

        if (index >= 0) {
            cargos[index].setValue(value);
        } else {
            for (int i = 0; i < SIZE_OF_STORAGE; i++) {
                if (cargos[i] == null) {
                    cargos[i] = new Cargo(key, value);
                    return;
                }
            }
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexOfKey(key);

        if (index >= 0 && cargos[index] != null) {
            return cargos[index].getValue();
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Cargo element : cargos) {
            if (element != null ) {
                size++;
            }
        }
        return size;
    }

    public int getIndexOfKey (K key) {
        for (int i = 0; i < cargos.length; i++) {
            if (cargos[i] != null) {
                if (cargos[i].getKey() != null && cargos[i].getKey().equals(key)) {
                    return i;
                }
                if (cargos[i].getKey() == null && key == null) {
                    return i;
                }
            }
        }
        return -1;
    }


}
