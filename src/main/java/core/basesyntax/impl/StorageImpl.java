package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size;
    private Container<K, V>[] cont;

    public StorageImpl() {
        cont = new Container[MAX_ELEMENTS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        Container<K, V> current = getCont(key);
        if (current != null) {
            current.cvalue = value;
            return;
        }
        cont[size] = new Container<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        Container<K, V> current = getCont(key);
        if (current != null) {
            return current.cvalue;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private Container<K, V> getCont(K key) {
        for (int i = 0; i < size; i++) {
            if ((cont[i].ckey == null && key == null)
                    || (cont[i].ckey != null && cont[i].ckey.equals(key))) {
                return cont[i];
            }
        }
        return null;
    }

    private static class Container<K, V> {
        private K ckey;
        private V cvalue;

        public Container(K key, V value) {
            ckey = key;
            cvalue = value;
        }
    }
}
