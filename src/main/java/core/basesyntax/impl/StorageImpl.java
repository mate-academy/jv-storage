package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final StorageImpl<K,V>[] list = new StorageImpl[MAX_ITEMS_NUMBER];
    private K typeK;
    private V typeV;
    private int size = 0;

    public StorageImpl(K typeK, V nameV) {
        this.typeK = typeK;
        this.typeV = nameV;
    }

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (list[i].typeK == null) {
                    list[i].typeV = value;
                    size--;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (list[i].typeK == null) {
                    break;
                }
                if (list[i].typeK.equals(key)) {
                    list[i].typeV = value;
                    size--;
                    break;
                }
            }
        }
        this.list[size] = new StorageImpl<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && list[i].typeK == null) {
                return list[i].typeV;
            }
            if (list[i].typeK == null) {
                i++;
            }
            if (list[i].typeK.equals(key)) {
                return list[i].typeV;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
