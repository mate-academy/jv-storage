package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int sizeOfStorage;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
        sizeOfStorage = 0;
    }

    private Integer indexOfKey(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        Integer index = indexOfKey(key);
        if (index != null) {
            this.values[index] = value;
            this.keys[index] = key;
        } else if (sizeOfStorage < MAX_ITEMS_NUMBER) {
            keys[sizeOfStorage] = key;
            values[sizeOfStorage] = value;
            sizeOfStorage++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = indexOfKey(key);
        if (index != null) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }

    @Override
    public String toString() {
        return "StorageImpl{"
                + "keys=" + Arrays.toString(keys)
                + ", values=" + Arrays.toString(values)
                + ", sizeOfStorage=" + sizeOfStorage
                + '}';
    }
}
