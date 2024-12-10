package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Map;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Node<K, V>[] nodes;
    private int size = 0;
    private int capacity = 10;
    private double capacityIncrement = 1.5;

    public StorageImpl() {
        nodes = new Node[capacity];
    }

    public int containsKey(K addingKey) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(nodes[i].getKey(), addingKey)) {
                return i;
            }
        }
        return -1;
    }

    private <T> T[] resizeArray(T[] array) {
        capacity = (int) (capacity * capacityIncrement);
        T[] newArray = (T[]) new Node[(int) (capacity)];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int index = containsKey(key);
        if (index != -1) {
            nodes[index].setValue(value);
        } else {
            if (size == capacity) {
                nodes = resizeArray(nodes);
            }
            nodes[size] = node;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(nodes[i].getKey(), key)) {
                return nodes[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        private final K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey());
        }
    }
}
