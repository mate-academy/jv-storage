package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int h = 10;
    private int size;
    private final K[] storageK = (K[]) new Object[h];
    private final V[] storageV = (V[]) new Object[h];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= size(); i++) {
            if (storageK[i] != null && storageK[i].equals(key)) {
                storageV[i] = value;
                break;
            }
            if (storageK[i] == null && storageV[i] == null) {
                storageK[i] = key;
                storageV[i] = value;
                size++;
                break;
            }
            if (key == null && value != null
                    && storageK[i] == null && storageV[i] != null
                    && !storageV[i].equals(value)) {
                storageK[i] = key;
                storageV[i] = value;
                break;
            }
            if (key == null && value != null && storageK[i] == null && storageV[i] == null) {
                storageV[i] = value;
                size++;
                break;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size(); i++) {
            if ((storageK[i] != null && storageK[i].equals(key))
                    || (key == null && storageK[i] == null && storageV[i] != null)) {
                return storageV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
