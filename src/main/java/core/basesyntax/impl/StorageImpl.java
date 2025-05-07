package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) { //если такой key есть в массиве keys
            values[index] = value; //то перезаписываем его value
        } else { //если нет
            keys[size] = key; //то добавляем новую запись key & value
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int i = getKeyIndex(key);
        if (i != -1) {
            return values[i];
        }
        return null;//прийдется вернуть null хоть это и bad practice но так требуют тесты
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (keys[i] != null && keys[i].equals(key) || key == null && keys[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

}
