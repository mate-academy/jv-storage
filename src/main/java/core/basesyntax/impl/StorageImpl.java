package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private Object[] valuesList = new Object[10];
    private Object[] keysList = new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keysList.length; i++) {
            if (keysList[i] == null && valuesList[i] != null && keysList[i] == key
                    || keysList[i] != null && keysList[i].equals(key)) {
                valuesList[i] = value;
                break;
            }
            if (keysList[i] == null && valuesList[i] == null) {
                keysList[i] = key;
                valuesList[i] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysList.length; i++) {
            if (keysList[i] == key && valuesList[i] != null
                    || keysList[i] != null && keysList[i].equals(key)) {
                return (V) valuesList[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
