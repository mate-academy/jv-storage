package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    K[] keys = (K[]) new Object[10];
    V[] values = (V[]) new Object[10];
    private Object[] items;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < keys.length; i++) {

            if (keys[i] == null && key == null) {
                values[i] = value;
                break;
            }
            if (keys[i] == null && key != null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
            if (keys[i].equals(key)) {
                values[i] = value;
                break;
            }

        }

    }

    @Override
    public V get(K key) {
        if (key == null) {

            for (int i = 0; i < size(); i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }

        } else {
            for (int i = 0; i < size(); i++) {

                if (keys[i].equals(key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(1, "two4");
        storage.put(null, "one");
        storage.put(null, "two");
        storage.put(null, "two");
        storage.put(2, "two5");
        storage.put(3, "two6");


        System.out.println(storage.size());

    }
}
