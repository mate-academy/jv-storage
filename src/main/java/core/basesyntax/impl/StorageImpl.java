package core.basesyntax.impl;

import core.basesyntax.Storage;

/*Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя типами данных,
и в этом хранилище можо класть значение по ключу и доставать значение по ключу.
Пример: Storage<Integer, Box> storage = new Storage<>(); storage.put(22, box);
storage.get(22) // вернёт коробку.
Реализовать на основе двух массивов (или одного массива в зависимости от реализации).
При реализации с помощью массива (массивов) ожидаем что количество елементов в
нашем Storage не превышает 10*/

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Object[] masKeys;
    private Object[] masValues;
    private int index;

    public StorageImpl() {
        masKeys = new Object[LENGTH];
        masValues = new Object[LENGTH];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (key == masKeys[i] || (key != null && key.equals(masKeys[i]))) {
                masValues[i] = value;
                return;
            }
        }
        masKeys[index] = key;
        masValues[index] = value;
        index++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == masKeys[i] || (key != null && key.equals(masKeys[i]))) {
                return (V) masValues[i];
            }
        }
        return null;
    }
}
