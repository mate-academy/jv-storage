package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        int index = 0;
        for (int i = 0; i < keys.length; i++) {
           if (keys[i].equals(key)) {
               index = i;
           }
        }
        return values[index];
    }

    @Override
    public int size() {
        return keys.length;
    }

    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box();
        storage.put(22, box);
        Box value = storage.get(22); // returns the Box
        int size = storage.size(); // returns storage size
        System.out.println(size);
        System.out.println(value);
    }
}
