package core.basesyntax.impl;

import core.basesyntax.Box;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return -1;
    }

    public static void main(String[] args) {
        //создаем наше хранилище
        Storage<Integer, Box> storage = new StorageImpl<>();
        //создаем объект с валью
        Box box = new Box();
        //заполнили наше хранилище первой парой
        storage.put(22, box);
    }
}
