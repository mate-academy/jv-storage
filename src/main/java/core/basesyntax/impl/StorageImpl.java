package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            int firstKeyNullIndex = this.getFirstKeyNullIndex();//find first index with key == null
            if (firstKeyNullIndex == -1 && size == 10) {
                //нет ни одного key==null, значит все key уже заполнены
                throw new RuntimeException("There are not empty elements in the storage");
            } else {
                if (values[firstKeyNullIndex] == null) {
                    this.values[firstKeyNullIndex] = value;//add value to this index
                    this.size++;
                } else {
                    this.values[firstKeyNullIndex] = value;//rewrite value at this index
                }
            }
        } else {
            int index = this.getKeyIndex(key);
            if (index == -1) {
                this.keys[this.size] = key;
                this.values[this.size] = value;
                this.size++;
            } else {
                this.values[index] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            int firstKeyNullIndex = this.getFirstKeyNullIndex();
            return values[firstKeyNullIndex];
        } else {
            int i = -1;
            for (K element : keys) {
                i++;
                if (element != null && element.equals(key)) {
                    return values[i];
                }
            }
            return null;//прийдется вернуть null хоть это и bad practice но так требуют тесты
        }
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

    private int getFirstKeyNullIndex() {
        int i = -1;
        for (K element : keys) {
            i++;
            if (element == null) {
                return i;
            }
        }
        return -1;
    }

}
