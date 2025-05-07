package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private final K[] keyArr;
    private final V[] valueArr;
    private int size = 0;

    public StorageImpl() {
        this.keyArr = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        this.valueArr = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_NUMBER_OF_ELEMENTS) {
            if (getIndex(key) >= 0) {
                valueArr[getIndex(key)] = value;
            } else {
                keyArr[size] = key;
                valueArr[size] = value;
                size++;
            }
        } else {
            System.out.println("Storage don't have free places");
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) >= 0) {
            return valueArr[getIndex(key)];
        } else {
            return null;
        }
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyArr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
