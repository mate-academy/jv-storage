package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] key;
    private V[] value;
    private int size = 0;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findByKey(key);

        if (size >= this.key.length) {
            increaseArrayLength(size);
        }

        if (index == -1) {
            this.key[size] = key;
            this.value[size] = value;
        } else {
            this.value[index] = value;
        }
        size++; //(*) when we are changing value by key size is incrementing too
    }

    @Override
    public V get(K key) {
        int index = findByKey(key);
        if (index != -1) {
            return value[index];
        }

        return null;
    }

    @Override
    public int size() { // we can't only return 'size' because of (*)
        return countNotNullValues();
    }

    private int findByKey(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void increaseArrayLength(int size) {
        K[] keyCopy = (K[]) new Object[size << 1];
        System.arraycopy(key, 0, keyCopy, 0, key.length);
        key = keyCopy;

        V[] valueCopy = (V[]) new Object[size << 1];
        System.arraycopy(value, 0, valueCopy, 0, value.length);
        value = valueCopy;
    }

    private int countNotNullValues() {
        int size = 0;

        for (V element : value) {
            if (element != null) {
                size++;
            }
        }

        return size;
    }
}
