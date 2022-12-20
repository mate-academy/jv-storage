package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Pair pair = new Pair();
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && pair.list[i].key == null) {
                pair.list[i].value = value;
                return;
            }
            if (pair.list[i].key == null) {
                break;
            }
            if (pair.list[i].key.equals(key)) {
                pair.list[i].value = value;
                return;
            }
        }
        this.pair.list[size] = new StorageImpl.Pair(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && pair.list[i].key == null) {
                return (V) pair.list[i].value;
            }
            if (pair.list[i].key == null) {
                i++;
            }
            if (pair.list[i].key.equals(key)) {
                return (V) pair.list[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Pair {
        private static final int MAX_ITEMS_NUMBER = 10;
        private final StorageImpl.Pair[] list = new StorageImpl.Pair[MAX_ITEMS_NUMBER];
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private Pair() {
        }
    }

}
