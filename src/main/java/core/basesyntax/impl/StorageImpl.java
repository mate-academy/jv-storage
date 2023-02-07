package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VALUE = 10;
    private int createdStorages;
    private Object[] keyArrayList = new Object[MAX_STORAGE_VALUE];
    private Object[] valueArrayList = new Object[MAX_STORAGE_VALUE];

    private K key;
    private V value;

    private boolean contains(Object[] array, Object o) {
        for (int i = 0; i < createdStorages; i++) {
            if (Objects.equals(array[i], o)) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(Object[] array, Object o) {
        for (int i = 0; i < createdStorages; i++) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (createdStorages < MAX_STORAGE_VALUE) {
            if (contains(keyArrayList, key)) {
                this.key = key;
                this.value = value;
                valueArrayList[indexOf(keyArrayList, key)] = value;
                keyArrayList[indexOf(keyArrayList, key)] = key;
                return;
            }
            this.key = key;
            this.value = value;
            keyArrayList[createdStorages] = key;
            valueArrayList[createdStorages] = value;
            createdStorages++;
        }
    }

    @Override
    public V get(K key) {
        if (!contains(keyArrayList, key)) {
            return null;
        }
        return (V) valueArrayList[indexOf(keyArrayList, key)];
    }

    @Override
    public int size() {
        return createdStorages;
    }
}
