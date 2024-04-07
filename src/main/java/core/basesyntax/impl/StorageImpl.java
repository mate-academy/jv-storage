package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int counter;
    private int index;
    private int size;
    private K key;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
        counter++;
    }

    @Override
    public void put(K key, V value) {
        if (counter == 0) {
            new StorageImpl<>();
        }
        for (int i = 0; i < keys.length; i++) {
            if (this.key == null && key == null && i > 0) {
                values[i] = value;
                return;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                this.key = key;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
        size++;
        this.key = key;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
