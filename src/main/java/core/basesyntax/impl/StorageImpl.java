package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 1;
    private K[] keys;
    private V[] values;
    private int size = 0;
    private int index = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int checkIndex = findByKey(key);

        if (index >= this.keys.length) {
            increaseArrayLength(index);
        }

        if (checkIndex == -1) {
            this.keys[index] = key;
            this.values[index] = value;
            size++; //UPD: the solution was very simple
        } else {
            this.values[checkIndex] = value;
        }
        index++; //(*) when we are changing value by key size is incrementing too
    }

    @Override
    public V get(K key) {
        int checkIndex = findByKey(key);
        if (checkIndex != -1) {
            return values[checkIndex];
        }

        return null;
    }

    @Override
    public int size() { // we can't only return 'size' because of (*)
        return size; // now we can
    }

    private int findByKey(K key) {
        for (int i = 0; i < this.keys.length; i++) {
            if (this.keys[i] == key || this.keys[i] != null && this.keys[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void increaseArrayLength(int size) {
        K[] keyCopy = (K[]) new Object[size << 1];
        System.arraycopy(keys, 0, keyCopy, 0, keys.length);
        keys = keyCopy;

        V[] valueCopy = (V[]) new Object[size << 1];
        System.arraycopy(values, 0, valueCopy, 0, values.length);
        values = valueCopy;
    }
}
