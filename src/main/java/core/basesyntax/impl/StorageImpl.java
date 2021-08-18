package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_LENGTH];
        values = new Object[MAX_LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = this.getIndex(key);
        if (index != -1 && this.size != 0) {
            this.values[index] = value;
        } else {
            if (size == this.keys.length) {
                this.addLength();
            }
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = this.getIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) this.values[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    private void addLength() {
        Object[] newKeys = new Object[size + MAX_LENGTH];
        Object[] newValues = new Object[size + MAX_LENGTH];

        for (int i = 0; i < this.size; i++) {
            newKeys[i] = this.keys[i];
            newValues[i] = this.values[i];
        }
        this.keys = newKeys;
        this.values = newValues;
    }

    private int getIndex(K key) {
        int index = -1;
        int localSize = this.size == 0 ? 1 : this.size;
        for (int i = 0; i < localSize; i++) {
            if ((key == this.keys[i]) || key != null && key.equals(this.keys[i])) {
                index = i;
            }
        }
        return index;
    }
}
