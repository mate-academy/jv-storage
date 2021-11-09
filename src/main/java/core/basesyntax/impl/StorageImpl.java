package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) { //если такой key есть в массиве keys
            this.values[index] = value; //то перезаписываем его value
            if (index >= size) {
                this.size++;
            }
        } else { //если нет
            this.keys[this.size] = key; //то добавляем новую запись key & value
            this.values[this.size] = value;
            this.size++;
        }
    }

    @Override
    public V get(K key) {
        int i = -1;
        for (K element : keys) {
            i++;
            if (element == key || element != null && element.equals(key)) {
                return values[i];
            }
        } //если перебрали весь массив keys и ни один из его элементов не совпал с key
        return null;//прийдется вернуть null хоть это и bad practice но так требуют тесты
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        if (this.size != 0) {
            int i = -1;
            for (K element : keys) {
                i++;
                if ((element != null && element.equals(key)) || (element == null && key == null)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
