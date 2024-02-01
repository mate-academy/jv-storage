package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair[] elements = new Pair[MAX_SIZE];
    private int counter = 0;
    private K key;
    private V value;

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        if (counter >= 9) {
            throw new ArrayIndexOutOfBoundsException("Array already full");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[counter] = new Pair(key, value);
                counter++;
                break;
            } else if (elements[i] != null && Objects.equals(elements[i].getKey(), key)) {
                elements[i].setValue(value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                return null;
            }
            if (Objects.equals(elements[i].getKey(), key)) {
                return (V) elements[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                return i;
            }
        }
        return 10;
    }

    private class Pair<K,V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
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
}
