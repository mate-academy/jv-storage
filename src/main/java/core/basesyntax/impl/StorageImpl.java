package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LIST_SIZE = 10;
    private StorageList<K,V>[] list;

    public StorageImpl() {
        list = new StorageList[MAX_LIST_SIZE];
    }

    @Override
    public void put(K key, V value) {
        StorageList<K,V> tempStorage = new StorageList<>(key, value);
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null
                    || (list[i] != null && (list[i].getKey() == key
                    || (list[i].getKey() != null && list[i].getKey().equals(key))))) {
                list[i] = tempStorage;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StorageList<K, V> kvStorageList : list) {
            if (kvStorageList != null && (kvStorageList.getKey() == key
                    || (kvStorageList.getKey() != null && kvStorageList.getKey().equals(key)))) {
                return kvStorageList.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int res = 0;
        for (StorageList<K, V> kvStorageList : list) {
            if (kvStorageList != null) {
                res++;
            }
        }
        return res;
    }
}
