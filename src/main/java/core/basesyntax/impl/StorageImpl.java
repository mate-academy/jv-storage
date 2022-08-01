package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE_ARRAY = 10;
    private K key;
    private V value;
    private Storage[] items = new Storage[MAX_VALUE_ARRAY];

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        int position = positionInArray(key);
        items[position] = new StorageImpl(key, value);
    }

    @Override
    public V get(K key) {
        int position = -1;
        for (int i = 0; i < size(); i++) {
            if ((items[i].getKey() == null && key == null)
                    || Objects.equals(items[i].getKey(), key)) {
                position = i;
            }
        }
        if (position == -1) {
            return null;
        }
        return (V) items[position].getValue();
    }

    @Override
    public int size() {
        int storageSize = 0;
        for (Storage item : items) {
            if (item != null) {
                storageSize++;
            } else {
                break;
            }
        }
        return storageSize;
    }

    private int positionInArray(K key) {
        for (int i = 0; i < size(); i++) {
            if ((items[i].getKey() == key) || Objects.equals(items[i].getKey(), key)) {
                return i;
            }
        }
        return size();
    }
}
