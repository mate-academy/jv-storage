package core.basesyntax.impl;

import core.basesyntax.Box;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 1;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
;




    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return -1;
    }

    //проверяем есть ли ключ в массиве ключей, если есть то вернем индекс
    //под которым будет наше валью, если такого значения нет, то возврат -1
    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            //проверка equals
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
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
