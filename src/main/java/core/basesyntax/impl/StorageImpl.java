package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.size = 0;
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = this.getKeyIndex(key);
        if (index == -1) {
            this.keys[this.size] = key;
            this.values[this.size] = value;
            this.size++;
        } else {
            this.values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int i = -1;
        for (K element : keys) {
            i++;
            if (element != null && element.equals(key)) {
                return values[i];
            }
        }
        return null;//прийдется вернуть null хоть это и bad practice но так требуют тесты
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getKeyIndex(K key) {
        if (this.size != 0) {
            int i = -1;
            for (K element : keys) {
                i++;
                if (element != null && element.equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
