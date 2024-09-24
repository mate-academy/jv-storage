package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int index = 0;
    private final StorageImpl<K, V>[] pairStorage = new StorageImpl[10];

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        boolean flag = true;

        if (index == 0) {
            pairStorage[0] = new StorageImpl<>();
            pairStorage[0].setKey(key);
            pairStorage[0].setValue(value);
        }

        if (index > 0) {
            for (int i = 1; i <= index; i++) {
                if (pairStorage[i - 1].getKey() == null && key == null
                        || pairStorage[i - 1].getKey() != null
                        && pairStorage[i - 1].getKey().equals(key)) {
                    pairStorage[i - 1].setValue(value);
                    flag = false;
                    index--;
                    break;
                }
            }

            if (flag) {
                pairStorage[index] = new StorageImpl<>();
                pairStorage[index].setKey(key);
                pairStorage[index].setValue(value);
            }
        }
        index++;
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> storage: pairStorage) {
            if (storage == null) {
                return null;
            }

            if (storage.getKey() == null && key == null) {
                return storage.getValue();
            }

            if (storage.getKey() != null && storage.getKey().equals(key)) {
                return storage.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
