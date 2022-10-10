package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int sizeOfStorage = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                this.values[i] = value;
                this.keys[i] = key;
                return;
            }
        }
        keys[sizeOfStorage] = key;
        values[sizeOfStorage] = value;
        sizeOfStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == null && keys[i] == null || key != null && key.equals(keys[i])) {
                return values[i];
            }
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
