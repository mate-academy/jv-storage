package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private int size = 0;

    private final V[] storageContents = (V[]) new Object [MAX_SIZE];
    private final K[] storageNames = (K[]) new Object [MAX_SIZE];

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, storageNames[i])) {
                storageContents[i] = value;
                size--;
            }
        }

        try {
            storageNames[size] = key;
            storageContents[size] = value;
            size++;
        } catch (Exception e) {
            if (size >= MAX_SIZE) {
                throw new StorageSizeException("Can't put value to storage, "
                        + "because storage is full");
            }
        }

    }

    @Override
    public V get(K key) {
        V output = null;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, storageNames[i])) {
                output = storageContents[i];
            }
        }
        return output;
    }

    @Override
    public int size() {
        return size;
    }

}
