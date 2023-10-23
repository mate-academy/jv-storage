package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Pair() {

        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] arrOfPair;
    private int size;

    public StorageImpl() {
        arrOfPair = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        int elementIndex = getElementIndex(key);
        if (elementIndex == -1) {
            arrOfPair[size] = new Pair<>(key, value);
            size++;
        } else {
            arrOfPair[elementIndex].setValue(pair.getValue());
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if ((arrOfPair[i].getKey() == key)
                    || (arrOfPair[i].getKey() != null && arrOfPair[i].getKey().equals(key))) {
                result = arrOfPair[i].getValue();
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public int getElementIndex(K key) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((arrOfPair[i].getKey() == key)
                    || (arrOfPair[i].getKey() != null && arrOfPair[i].getKey().equals(key))) {
                index = i;
                break;
            }
        }
        return index;
    }
}
