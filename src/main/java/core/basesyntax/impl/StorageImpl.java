package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final StorageImpl[] array = new StorageImpl[MAX_SIZE];
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
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[counter] = new StorageImpl(key, value);
                counter++;
                break;
            } else if (array[i] != null && Objects.equals(array[i].getKey(), key)) {
                array[i].setValue(value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return null;
            }
            if (Objects.equals(array[i].getKey(), key)) {
                return (V) array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return 10;
    }
}
